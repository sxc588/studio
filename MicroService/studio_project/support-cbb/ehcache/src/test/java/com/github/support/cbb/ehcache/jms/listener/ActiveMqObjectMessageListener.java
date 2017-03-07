package com.github.support.cbb.ehcache.jms.listener;

import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;



//MessageListenerAdapter会把接收到的消息做如下转换：
//1. TextMessage转换为String对象；
//2. BytesMessage转换为byte数组；
//3. MapMessage转换为Map对象；
//4. ObjectMessage转换为对应的Serializable对象。
public class ActiveMqObjectMessageListener implements MessageListener
{
	private Logger logger = LoggerFactory.getLogger(ActiveMqObjectMessageListener.class);
	
	public void onMessage(Message message)
	{
		logger.info("★★★★★★★★★★★ 接受到ActiveMQObjectMessage消息.");
		handler((ActiveMQObjectMessage)message);
		logger.info("★★★★★★★★★★★ 处理完ActiveMQObjectMessage消息.");
	}
	private void handler(ActiveMQObjectMessage activeMQMessage)
	{

		 // 这里我们知道生产者发送的就是一个纯文本消息，所以这里可以直接进行强制转换
		// 或者直接把onMessage方法的参数改成Message的子类TextMessage  
		//Serializable obj;
	}
}
