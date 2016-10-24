package com.huawei.support.cbbservice.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class QuartzJobUpload implements Job
{
	
	private Logger logger  = LoggerFactory.getLogger(QuartzJobUpload.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.error("★★★★★★★★★★★ 上传病毒扫描中心");
		

		logger.info("★★★★★★★★★★★ 完成病毒扫描中心");
	}
	
}
