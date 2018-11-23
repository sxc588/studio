package com.github.support.quartz.jms;

import javax.annotation.Resource;
import javax.jms.Destination;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.support.quartz.jms.QueueSender;
import com.github.support.quartz.jms.TopicSender;

/*
 * ActivemqController 
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("/applicationContext.xml")
public class ActivemqController {
	@Resource
	private QueueSender queueSender;
	
	@Resource
	private TopicSender topicSender;
	
	@Resource
	@Qualifier("queueDestination")
	private Destination queueDestination;
	
	@Resource
	@Qualifier("topicDestination")
	private Destination topicDestination;

	@Test
	public void testSend() {
		for (int i = 0; i < 5; i++) {
			queueSender.sendMessage(queueDestination, "queue生产者产生消息：" + (i + 1));
		}
		
		for (int i = 0; i < 5; i++) {
			topicSender.sendMessage(topicDestination, "topic生产者产生消息：" + (i + 1));
		}
	}
}