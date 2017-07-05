package com.github.cbb.migrate;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.CompletionService;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.xml.crypto.Data;
import org.apache.commons.collections.CollectionUtils;
import org.fkjava.domain.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;


/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据filed , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class MigrateRunTasksBase
{

	private static Logger logger= LoggerFactory.getLogger(MigrateRunTasksBase.class);
	
	private class doWork implements Callable<Integer>
	{
		List<User> users;
		private doWork(List<User> users)
		{
			this.users = users;
		}
		@Override
		public Integer call() throws Exception
		{

			int sum= 0;

			if (CollectionUtils.isNotEmpty(users))
			{
				for (User user : users)
				{
				// sum += dealOne(user);
				}
			}
			return sum;
		}
	}

	ExecutorService es = Executors.newCachedThreadPool();
	
	boolean migratinAll()
	{
		return migratin(null,null,"全量迁移");
	}
	
	public boolean migratinAll(Data begin ,Date end)
	{
		return migratin(begin,begin,"增量迁移");
	}

	private  boolean migratin(Data begin,Data end, String desc)
	{
		if (es.isTerminated())
		{
			// 检测到前一次调动任务还在执行
			return false;
		}
		CompletionService<Integer> cs = new ExecutorCompletionService<Integer>(es);
		List<Future<Integer>> fs = new ArrayList<Future<Integer>>();

		List<User> users = getAll();
		while (CollectionUtils.isNotEmpty(users))
		{
			Callable<Integer> task = new doWork(users);
			Future<Integer> feature = cs.submit(task);
			fs.add(feature);
			
			users = getAll();
		}

		String name = this.getClass().getSimpleName();
		
		/**
		 * 等待线程池结束
		 */
		Future<Integer> feature  = null;
		try
		{
			feature = cs.take();
		}
		catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		while (feature != null)
		{
			try
			{
				Integer afectCount = feature.get();
				// 记录线程执行结果日志
				logger.info(afectCount.toString());
			}
			catch (InterruptedException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			catch (ExecutionException e)
			{
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return true;
	}

	void delete(Data begin ,Date end)
	{
	}

	public  List<User> getAll()
	{
		List<User> users = new ArrayList<User>();
		return users;
	}
	
}
