package com.github.support.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by Administrator on 2017/1/5.
 */
public class QueueMessageListener implements MessageListener
{
	

	/* 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ActiveMqProducerService.class);
	
	public void onMessage(Message message)
	{
		TextMessage tm = (TextMessage) message;
		try
		{
			
			LOG.info(Thread.currentThread().getName() + "QueueMessageListener监听到了文本消息：\t" + tm.getText());
			// do something ...
		} catch (JMSException e)
		{
			e.printStackTrace();
		}
	}
}
