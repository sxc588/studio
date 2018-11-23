package com.github.support.quartz.jms;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;


/**
 * 利用Spring与ActiveMQ整合发送、接收消息实例(Queue与Topic模式)
 * https://blog.csdn.net/u012358328/article/details/77749779
 * 
 * 
 * .接收topic消息的消费者1：
 * @author Administrator
 *
 */
public class TopicReceiver1 implements MessageListener
{


	/*
	 * (非 Javadoc) <p>Title: onMessage</p> <p>Description: </p>
	 * 
	 * @param arg0
	 * 
	 * @see javax.jms.MessageListener#onMessage(javax.jms.Message)
	 */
	@Override
	public void onMessage(Message message) {
		// TODO Auto-generated method stub
		TextMessage textMessage = (TextMessage) message;
		try {
			System.out.println("TopicReceiver1接收到消息内容是：" + textMessage.getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
