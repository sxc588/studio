package com.github.support.cbbservice.quartz.job;

import javax.jms.Destination;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.github.support.cbbservice.jms.JMSMessageService;

public class QuartzJob implements Job
{
	private Logger logger = LoggerFactory.getLogger(QuartzJob.class);

	@Override
	public void execute(JobExecutionContext arg0) throws JobExecutionException
	{
		logger.info("★★★★★★★★★★★ 动态Job执行开始");
		
		JMSMessageService jmsMessageService = HandlerServiceManager.getInstance().getJmsMessageService();
		Destination destination=  HandlerServiceManager.getInstance().getDestination();
		

		for (int i = 1000; i < 2000; i++)
		{
			jmsMessageService.sendMessage(destination, "你好，生产者！这是队列消息：" + (i + 1));
		}
		
	//	List<Sysconfig> abc = sysconfigMapper.getAllAccount();
//		logger.info(abc.toString());
//	producerService.sendMessage("DDF");
		
		logger.info("★★★★★★★★★★★  动态Job执行结束");
	}

}
