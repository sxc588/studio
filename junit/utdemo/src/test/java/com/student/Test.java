package com.student;

import java.util.Date;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerFactory;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class Test
{

	public static void main(String[] args)
	{

		// 1、工厂模式 构建Scheduler的Factory，其中STD为Quartz默认的Factory
		// 开发者亦可自行实现自己的Factory;Job、Trigger等组件
		SchedulerFactory sf = new StdSchedulerFactory();

		// 2、通过SchedulerFactory构建Scheduler对象
		Scheduler sched = sf.getScheduler();

		// 3、org.quartz.DateBuilder.evenMinuteDate -- 通过DateBuilder构建Date
		Date runTime = org.quartz.DateBuilder.evenMinuteDate(new Date());

		// 4、org.quartz.JobBuilder.newJob <下一分钟> --通过JobBuilder构建Job
		JobDetail job = org.quartz.JobBuilder.newJob(Myjob.class).withIdentity("job1", "group1").build();

		// 5、通过TriggerBuilder进行构建Trigger
		Trigger trigger = newTrigger().withIdentity("trigger1", "group1").startAt(runTime).build();

		// 6、工厂模式，组装各个组件<JOB，Trigger>
		sched.scheduleJob(job, trigger);

		// 7、start
		sched.start();

		try
		{
			Thread.sleep(65L * 1000L);
		} catch (Exception e)
		{
		}

		// 8、通过Scheduler销毁内置的Trigger和Job
		sched.shutdown(true);
	}

}
