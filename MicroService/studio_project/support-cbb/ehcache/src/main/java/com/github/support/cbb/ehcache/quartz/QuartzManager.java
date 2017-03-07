/** 
 * @Description:  
 * 
 * @Title: QuartzManager.java 
 * @Package com.joyce.quartz 
 * @Copyright: Copyright (c) 2016 
 * 
 * @author Comsys-LZP 
 * @date 2014-6-26 下午03:15:52 
 * @version V2.0 
 */

package com.github.support.cbb.ehcache.quartz;

import java.text.ParseException;
import org.quartz.CronScheduleBuilder;
import org.quartz.CronTrigger;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobKey;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;
import org.quartz.impl.StdSchedulerFactory;

/**
 * @Description: 定时任务管理类.
 * 
 * @ClassName: QuartzManager
 * @Copyright: Copyright (c) 2016
 * 
 * @author Comsys-LZP
 * @date 2014-6-26 下午03:15:52
 * @version V2.0
 */
public class QuartzManager
{
	// 首先，必需要取得一个Scheduler的引用
	private static SchedulerFactory gSchedulerFactory = new StdSchedulerFactory();
	private static String GROUP_NAME_JOB = "EXTJWEB_JOBGROUP_NAME";
	private static String GROUP_NAME_TRIGGER = "EXTJWEB_TRIGGERGROUP_NAME";

	/**
	 * @Description: 添加一个定时任务，使用默认的任务组名，触发器名，触发器组名
	 * @param jobName
	 *            任务名
	 * @param cls
	 *            任务
	 * @param time
	 *            时间设置，参考quartz说明文档
	 * @Title: QuartzManager.java
	 * @author
	 * @throws ParseException
	 * @throws SchedulerException
	 * @date 2014-6-26 下午03:47:44 50.
	 */
	public static void addJob(String jobName, Class<? extends Job> jobClass, String time) throws ParseException, SchedulerException
	{
		String triggerName = jobName;
		addJob(jobName, GROUP_NAME_JOB, triggerName, GROUP_NAME_TRIGGER, jobClass, time);
	}

	/**
	 * @Description: 添加一个定时任务
	 * @param jobName
	 *            任务名
	 * @param jobGroupName任务组名
	 * @param triggerName
	 *            触发器名
	 * @param triggerGroupName
	 *            触发器组名
	 * @param jobClass
	 *            任务
	 * @param time时间设置
	 *            ，参考quartz说明文档
	 * @Title: QuartzManager.java
	 * @author s00318828
	 * @throws ParseException
	 * @throws SchedulerException
	 * @date 2016-09-15 下午03:48:15 91.
	 */
	public static void addJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName,Class<? extends Job>  jobClass, String cronExpression) throws ParseException, SchedulerException
	{
		// 获取调度器实例
		Scheduler scheduler = gSchedulerFactory.getScheduler();

		// 指明job的名称，所在组的名称，以及绑定job类 创建jobDetail实例，绑定Job实现类
		JobDetail jobDetail = JobBuilder.newJob(jobClass).withIdentity(jobName, jobGroupName).build();

		// 括号里面的*号依此为秒，分，时，天，周，月，年
		// cornTrigger.setCronExpression("0/1 * * * * ? *");
		CronScheduleBuilder cronSchedule = CronScheduleBuilder.cronSchedule(cronExpression);
		CronTrigger cornTrigger = TriggerBuilder.newTrigger().withIdentity(triggerName, triggerGroupName).withSchedule(cronSchedule).build();

		// 把作业和触发器注册到任务调度中
		scheduler.scheduleJob(jobDetail, cornTrigger);

		// 启动调度
		if (!scheduler.isShutdown())
		{
			scheduler.start();
		}

	}

	/**
	 * @Description: 修改一个任务的触发时间(使用默认的任务组名，触发器名，触发器组名)
	 * @param jobName
	 * @param time
	 * @Title:QuartzManager.java 116.
	 * @Copyright: Copyright (c) 2014
	 * @author s00318828
	 * @throws SchedulerException
	 * @throws ParseException
	 * @date 2016-09-15 下午03:48:15 91.
	 */
	public static void modifyJobTime(String jobName, String time) throws SchedulerException, ParseException
	{
		Scheduler scheduler = gSchedulerFactory.getScheduler();

		CronTrigger trigger = (CronTrigger) scheduler.getTrigger(TriggerKey.triggerKey(jobName, GROUP_NAME_TRIGGER));
		if (trigger == null)
		{
			return;
		}
		String oldTime = trigger.getCronExpression();
		if (!oldTime.equalsIgnoreCase(time))
		{
			JobDetail jobDetail = scheduler.getJobDetail(JobKey.jobKey(jobName, GROUP_NAME_JOB));
			Class<? extends Job> objJobClass = jobDetail.getJobClass();
			removeJob(jobName);
			addJob(jobName, objJobClass, time);
		}
	}

	/**
	 * @Description: 修改一个任务的触发时间
	 * @param triggerName
	 * @paramtriggerGroupName
	 * @param time
	 * @Title: QuartzManager.java
	 * @Copyright: Copyright (c) 2014
	 * @author s00318828
	 * @date 2016-09-15 下午03:48:15 91.
	 */
	// public static void modifyJobTime(String triggerName, String
	// triggerGroupName, String time)
	// {
	// try
	// {
	// Scheduler sched = gSchedulerFactory.getScheduler();
	// CronTrigger trigger = (CronTrigger) sched.getTrigger(triggerName,
	// triggerGroupName);
	// if (trigger == null)
	// {
	// return;
	// }
	// String oldTime = trigger.getCronExpression();
	// if (!oldTime.equalsIgnoreCase(time))
	// {
	// // 修改时间
	// CronExpression cronExpression = new CronExpression(time);
	// trigger.setCronExpression(cronExpression);
	// // 重启触发器
	// sched.resumeTrigger(triggerName, triggerGroupName);
	// }
	// } catch (Exception e)
	// {
	// throw new RuntimeException(e);
	// }
	// }

	/**
	 * @Description: 移除一个任务(使用默认的任务组名，触发器名，触发器组名)
	 * @param jobName
	 * @Title: QuartzManager.java
	 * @author s00318828
	 * @throws SchedulerException
	 * @date 2016-09-15 下午03:48:15 91.
	 */
	public static void removeJob(String jobName) throws SchedulerException
	{
		String triggerName = jobName;

		removeJob(jobName, GROUP_NAME_JOB, triggerName, GROUP_NAME_TRIGGER);
	}

	/**
	 * @Description: 移除一个任务
	 * @param jobName
	 * @param triggerName
	 * @param triggerGroupName
	 * @throws SchedulerException
	 * @Title: QuartzManager.java
	 */
	public static void removeJob(String jobName, String jobGroupName, String triggerName, String triggerGroupName) throws SchedulerException
	{
		Scheduler scheduler = gSchedulerFactory.getScheduler();
		TriggerKey triggerKey = TriggerKey.triggerKey(jobName, triggerGroupName);
		JobKey jobKey = JobKey.jobKey(jobName, jobGroupName);

		scheduler.pauseTrigger(triggerKey);// 停止触发器
		scheduler.unscheduleJob(triggerKey);// 移除触发器
		scheduler.deleteJob(jobKey);// 删除任务
	}

	/**
	 * @throws SchedulerException
	 * @Description:启动所有定时任务
	 * @Title: QuartzManager.java
	 */
	public static void startJobs() throws SchedulerException
	{
		Scheduler sched = gSchedulerFactory.getScheduler();
		sched.start();
	}

	/**
	 * @throws SchedulerException
	 * @Description:关闭所有定时任务
	 * @Title: QuartzManager.java
	 */
	public static void shutdownJobs() throws SchedulerException
	{
		Scheduler sched = gSchedulerFactory.getScheduler();
		if (!sched.isShutdown())
		{
			sched.shutdown();
		}
	}
}
