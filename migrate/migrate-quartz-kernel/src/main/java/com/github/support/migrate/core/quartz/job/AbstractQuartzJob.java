package com.github.support.migrate.core.quartz.job;

import java.util.Date;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.support.migrate.core.handler.IMigrateHandler;
import com.github.support.migrate.core.log.ILogService;
import com.github.support.migrate.core.quartz.task.ITaskManager;
import com.github.support.migrate.core.quartz.task.Task;

public abstract class AbstractQuartzJob implements Job
{
	private static Logger Logger = LoggerFactory.getLogger(AbstractQuartzJob.class);

	/**
	 * 迁移处理逻辑类
	 */
	protected abstract IMigrateHandler getMigrateHandler(String taskName);
	
	/**
	 * 迁移任务管理类
	 */
	protected abstract ITaskManager getTaskManager(String taskName);
	
	/**
	 * 迁移日志管理类
	 */
	protected abstract ILogService getLogMapper(String taskName);

	public static String appendAble(Object... args)
	{
		StringBuilder sBuilder = new StringBuilder();
		for (Object v : args)
		{
			if (v != null) sBuilder.append(v.toString());
		}
		System.out.println();

		return sBuilder.toString();
	}

	@Override
	public void execute(JobExecutionContext context) throws JobExecutionException
	{
		context.getMergedJobDataMap().get("JOB_NAME");
		
		String taskName = (String) context.getMergedJobDataMap().get("JOB_NAME");

		String info = appendAble("【__________________________________________系统启动】", taskName);

		Logger.info(info);

		IMigrateHandler handler = getMigrateHandler(taskName);

		ITaskManager taskManager = getTaskManager(taskName);
		
		ILogService logMapper = getLogMapper(taskName);

		Task task = taskManager.getTask(taskName);

		if (!task.getEnable())
		{
			Logger.info("定时任务被禁用了name =" + taskName);
			return;
		}

		if (task.getIncrease())
		{
			// 全量迁移:1. 指定时间段迁移; 2.删除逻辑 3.成功更新最后时间
			Date startTime = task.getEndTime();
			Date endTime = task.getEndTime();
			try
			{
				handler.migrate(startTime, endTime, false);
			}
			catch (Throwable e)
			{
				logMapper.log(taskName, "全量迁移", e.toString());
			}
		}
		else
		{
			// 增量迁移:1. 指定时间段迁移; 2.删除逻辑 3.成功更新最后时间
			Date startTime = task.getEndTime();
			Date endTime = taskManager.getDBTime();
			try
			{
				handler.migrate(startTime, endTime, true);

				// 更新结束时间
				taskManager.updateEndTime(taskName, endTime);

				// logMapper.log(name,"增量迁移",startTime,endTime,"成功");
			}
			catch (Throwable e)
			{
				logMapper.log("Error", taskName, "全量迁移", startTime, endTime, e.toString());
			}

		}
	}


}
