package com.github.support.quartz.event;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import javax.annotation.PostConstruct;

import org.apache.lucene.document.Field.Index;
import org.quartz.JobDetail;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.github.support.quartz.service.ScheduleJobService;
import com.github.support.vo.ScheduleJobVo;

/**
 * author : benjamin createTime : 2017.06.06 description : 定时任务初始化 version : 1.0
 */
@Component
public class ScheduleJobInit
{

	// ExecutorService cachedThreadPool = Executors.newCachedThreadPool();

	 ExecutorService fixedThreadPool = Executors.newFixedThreadPool(300);
	
	ExecutorService singleThreadExecutor = Executors.newSingleThreadExecutor();

	/** 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ScheduleJobInit.class);

	/** 定时任务service */
	@Autowired
	private ScheduleJobService scheduleJobService;

	/**
	 * 项目启动时初始化
	 */
	@PostConstruct
	public void init()
	{

		if (LOG.isInfoEnabled())
		{
			LOG.info("init");
		}
		//scheduleJobService.initScheduleJob();
		
//		
//		fixedThreadPool.execute(new Runnable()
//		{
//
//			@Override
//			public void run()
//			{
//
//				
//				for (long index= 200000; index <202000; index++)
//				{
//					ScheduleJobVo sjv = new ScheduleJobVo();
//					
//					sjv.setScheduleJobId(index);
//					sjv.setJobName("jobName" + index);
//					sjv.setAliasName("aliasName" + index);
//					sjv.setJobGroup("jobGroup");
//					sjv.setJobTrigger("jobTrigger"+index);
//					sjv.setStatus("ddd");
//					sjv.setCronExpression("0 */5 * * * ?");
//					sjv.setIsSync(false);
//					sjv.setDescription("description"+index);
//					sjv.setUrl("http://support.huawei.com/monitor");
//				
//					try
//					{
//						JobDetail detail = scheduleJobService.getJobDetails(sjv.getJobGroup(), sjv.getJobName());
//						
//						if (detail != null)
//						{
//							scheduleJobService.update(sjv);
//							System.err.println("update==>" + sjv.getScheduleJobId() );
//						}
//						else
//						{
//							scheduleJobService.insert(sjv);
//							System.err.println("insert==>" + sjv.getScheduleJobId() );
//						}
//						
//					} catch (Exception e) {
//						// TODO: handle exception
//					}finally
//					{
//						// TODO: handle finally clause
//					}
//	
//					//scheduleJobService.insert(scheduleJobVo);
//				}
//				
//			}
//		});

	//	scheduleJobService.initScheduleJob();

		if (LOG.isInfoEnabled())
		{
			LOG.info("end");
		}
	}

}
