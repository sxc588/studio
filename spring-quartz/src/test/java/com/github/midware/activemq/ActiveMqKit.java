package com.github.midware.activemq;

import java.io.IOException;
import java.util.PriorityQueue;

import javax.management.MBeanServerConnection;
import javax.management.MBeanServerInvocationHandler;
import javax.management.MalformedObjectNameException;
import javax.management.ObjectName;
import javax.management.remote.JMXConnector;
import javax.management.remote.JMXConnectorFactory;
import javax.management.remote.JMXServiceURL;

import org.apache.activemq.broker.jmx.BrokerViewMBean;
import org.apache.activemq.broker.jmx.QueueViewMBean;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

public class ActiveMqKit
{

	public static final String reportQueueName = "zc-queue-actual";// 生成核对报告队列名
	private static Log log = LogFactory.getLog(ActiveMqKit.class);
	private static final String connectorPort = "11099";
	private static final String connectorPath = "/jmxrmi";
	private static final String jmxDomain = "org.apache.activemq";

	public static PriorityQueue<MQQue> getAllQueue(String ip) throws Exception
	{

		BrokerViewMBean mBean = null;
		MBeanServerConnection connection = null;
		PriorityQueue<MQQue> ques = new PriorityQueue<MQQue>();
		try
		{
			JMXServiceURL url = new JMXServiceURL(
					"service:jmx:rmi:///jndi/rmi://" + ip + ":" + connectorPort + connectorPath);
			JMXConnector connector = JMXConnectorFactory.connect(url);
			connector.connect();
			connection = connector.getMBeanServerConnection();
			ObjectName name = new ObjectName(jmxDomain + ":brokerName=localhost,type=Broker");
			mBean = MBeanServerInvocationHandler.newProxyInstance(connection, name, BrokerViewMBean.class, true);
		} catch (IOException e)
		{
			log.error("ActiveMQUtil.getAllQueueSize", e);
		} catch (MalformedObjectNameException e)
		{
			log.error("ActiveMQUtil.getAllQueueSize", e);
		}
		if (mBean != null)
		{
			for (ObjectName queueName : mBean.getQueues())
			{
				QueueViewMBean queueMBean = MBeanServerInvocationHandler.newProxyInstance(connection, queueName,
						QueueViewMBean.class, true);
				MQQue que = new MQQue();
				que.setName(queueMBean.getName());
				que.setQueueSize(queueMBean.getQueueSize());
				que.setConsumerCount(queueMBean.getConsumerCount());
				que.setDequeueCount(queueMBean.getDequeueCount());
				if (ques.size() <= 2)
				{
					ques.add(que);
				} else
				{
					if (que.getQueueSize() > ques.peek().getQueueSize())
					{
						ques.poll();
						ques.add(que);
					}
				}
				// System.out.println("Queue Name --- " +
				// queueMBean.getName());// 消息队列名称
				// System.out.println("Queue Size --- " +
				// queueMBean.getQueueSize());// 队列中剩余的消息数
				// System.out.println("Number of Consumers --- " +
				// queueMBean.getConsumerCount());// 消费者数
				// System.out.println("Number of Dequeue ---" +
				// queueMBean.getDequeueCount());// 出队数
			}
		}

		return ques;
	}
}