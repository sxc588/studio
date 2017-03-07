package com.github.support.cbb.ehcache.quartz.job;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class QuartzJobCheckResult implements Job
{
	private Logger logger = LoggerFactory.getLogger(QuartzJobMigration.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("★★★★★★★★★★★ 轮休扫描结果-----");

	//	List<Sysconfig> abc = sysconfigMapper.getAllAccount();
//		logger.info(abc.toString());
//	producerService.sendMessage("DDF");
		
		logger.info("★★★★★★★★★★★ 轮休扫描结果");
	}

}
