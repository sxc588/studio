package com.github;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;
import org.quartz.Job;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.SchedulerFactory;
import org.quartz.SimpleScheduleBuilder;
import org.quartz.SimpleTrigger;
import org.quartz.TriggerBuilder;
import org.quartz.impl.StdSchedulerFactory;

public class PickNewsJob implements Job
{

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		System.err.println("在" + sdf.format(new Date()) + "扒取新闻");

	}

	@Test
	public void main() throws SchedulerException, InterruptedException
	{
		Long dt =  new Date().getTime();
		
		
		
		JobDetail jobDetail = JobBuilder.newJob(PickNewsJob.class).withIdentity("job1", "jgroup1" +dt).build();
		SimpleTrigger simpleTrigger = TriggerBuilder.newTrigger().withIdentity("trigger1" + dt)
				.withSchedule(SimpleScheduleBuilder.repeatSecondlyForTotalCount(10, 2)).startNow().build();

		// 创建scheduler
		SchedulerFactory schedulerFactory = new StdSchedulerFactory();
		Scheduler scheduler = schedulerFactory.getScheduler();
		scheduler.scheduleJob(jobDetail, simpleTrigger);
		scheduler.start();
		
		Thread.sleep(10000);
	}

}
