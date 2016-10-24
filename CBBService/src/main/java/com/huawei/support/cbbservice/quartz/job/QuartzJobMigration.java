package com.huawei.support.cbbservice.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzJobMigration implements Job
{
	private Logger logger  = LoggerFactory.getLogger(QuartzJobMigration.class);
	
	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		
		logger.info("★★★★★★★★★★★ QuartzJobMigration");
		
		
		logger.info("★★★★★★★★★★★ QuartzJobMigration");
		
	}
	
}
