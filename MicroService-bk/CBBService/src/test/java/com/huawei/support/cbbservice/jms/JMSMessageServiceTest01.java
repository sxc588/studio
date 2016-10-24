package com.huawei.support.cbbservice.jms;

import javax.jms.Destination;
import javax.jms.JMSException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;



@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring/spring-jms.xml")
public class JMSMessageServiceTest01
{

	@Autowired
	private JMSMessageService jmsMessageService;

	@Autowired
	@Qualifier("queueDestination")
	private Destination destination;

	@Test
	public void testSend()
	{
		for (int i = 1000; i < 2000; i++)
		{
			jmsMessageService.sendMessage(destination, "你好，生产者！这是队列消息：" + (i + 1));
		}
	}
	
	@Test
	public void testSend2() throws JMSException
	{
		Destination queue = jmsMessageService.createQueue("queue");
		
		for (int i = 100; i < 1000; i++)
		{
			jmsMessageService.sendMessage(queue,"你好，生产者！这是队列消息：" + (i + 1));
		}
	}
	
	@Test
	public void testSendObject() throws JMSException
	{
		Destination queue = jmsMessageService.createQueue("queue");
		
		for (int i = 1000; i < 2000; i++)
		{
			JMSMessage msg = new JMSMessage();
			msg.setMessage("你好，生产者！这是队列消息：" + (i + 1));
			jmsMessageService.sendMessage(queue, msg);
		}
	}

}
