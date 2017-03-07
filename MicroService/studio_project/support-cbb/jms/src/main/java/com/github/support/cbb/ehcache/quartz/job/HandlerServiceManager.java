package com.github.support.cbb.ehcache.quartz.job;

import javax.jms.Destination;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import com.github.support.cbb.ehcache.jms.JMSMessageService;

@Service
public class HandlerServiceManager implements InitializingBean
{

	@Autowired
	private JMSMessageService jmsMessageService;

	/**
	 * @return the jmsMessageService
	 */
	public JMSMessageService getJmsMessageService()
	{
		return jmsMessageService;
	}

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	/**
	 * @return the destination
	 */
	public Destination getDestination()
	{
		return destination;
	}

	static HandlerServiceManager handlerServiceManager;

	@Override
	public void afterPropertiesSet() throws Exception
	{
		handlerServiceManager = this;
	}

	public static HandlerServiceManager getInstance()
	{
		return handlerServiceManager;
	}

}
