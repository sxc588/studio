package com.bjsxt.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.bjsxt.model.User;
import com.juvenxu.mvnbook.account.ActiveMQSender.ActiveMQConnectionFactory;
import com.juvenxu.mvnbook.account.ActiveMQSender.Connection;
import com.juvenxu.mvnbook.account.ActiveMQSender.ConnectionFactory;
import com.juvenxu.mvnbook.account.ActiveMQSender.Destination;
import com.juvenxu.mvnbook.account.ActiveMQSender.MessageProducer;
import com.juvenxu.mvnbook.account.ActiveMQSender.Session;
import com.juvenxu.mvnbook.account.ActiveMQSender.TextMessage;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * JMSHelper;
 * 
 * @author Administrator
 *
 */
public class JMSHelper
{
	private Cache cache;

	Log LOG = LogFactory.getLog(JMSHelper.class);

	public Cache Init() throws IOException
	{
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver.getResource("ehcache.config.xml");
		InputStream is = null;
		is = resource.getInputStream();

		CacheManager manager = CacheManager.create(is);

		Cache cache = manager.getCache("SystemConfigCache");

		return cache;
	}

	
	private static final int SEND_NUMBER = 5;

	public static void main(String[] args)
	{
		// ConnectionFactory ：连接工厂，JMS 用它创建连接
		ConnectionFactory connectionFactory;
		// Connection ：JMS 客户端到JMS Provider 的连接
		Connection connection = null;
		// Session： 一个发送或接收消息的线程
		Session session;
		// Destination ：消息的目的地;消息发送给谁.
		Destination destination;
		// MessageProducer：消息发送者
		MessageProducer producer;
		// TextMessage message;
		// 构造ConnectionFactory实例对象，此处采用ActiveMq的实现jar
		connectionFactory = new ActiveMQConnectionFactory(ActiveMQConnection.DEFAULT_USER,
				ActiveMQConnection.DEFAULT_PASSWORD, "tcp://localhost:61616");
		try
		{
			// 构造从工厂得到连接对象
			connection = connectionFactory.createConnection();
			// 启动
			connection.start();
			// 获取操作连接
			session = connection.createSession(Boolean.TRUE, Session.AUTO_ACKNOWLEDGE);
			// 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
			destination = session.createQueue("FirstQueue");
			// 得到消息生成者【发送者】
			producer = session.createProducer(destination);
			// 设置不持久化，此处学习，实际根据项目决定
			producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
			// 构造消息，此处写死，项目就是参数，或者方法获取
			sendMessage(session, producer);
			session.commit();
		} catch (Exception e)
		{
			e.printStackTrace();
		} finally
		{
			try
			{
				if (null != connection)
					connection.close();
			} catch (Throwable ignore)
			{
			}
		}
	}

	public static void sendMessage(Session session, MessageProducer producer) throws Exception
	{
		for (int i = 1; i <= SEND_NUMBER; i++)
		{
			TextMessage message = session.createTextMessage("ActiveMq 发送的消息" + i);
			// 发送消息到目的地方
			System.out.println("发送消息：" + "ActiveMq 发送的消息" + i);
			producer.send(message);
		}
	}
	protected Cache loadCache(Resource resource)
	{

		try
		{
			InputStream is = resource.getInputStream();
			CacheManager manager = CacheManager.create(is);

			Cache cache = manager.getCache("SystemConfigCache");

			return cache;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	protected Collection<? extends Cache> loadCaches() throws IOException
	{
		Collection<Cache> caches = new LinkedHashSet<Cache>();

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:ehcache*.xml");
		for (Resource resource : resources)
		{
			Cache cache = loadCache(resource);
			if (null != cache)
			{
				caches.add(cache);
			}
		}
		return caches;
	}

	public void put(String key, String value)
	{
		if (null == cache)
		{
			LOG.error("缓存对象为空，缓存数据失败！ key=" + key);
			return;
		}

		this.cache.put(new Element(key, value));
		LOG.error("缓存数据成功！- key=" + key);
	}

	public User get(String key)
	{
		if (null == cache)
		{
			LOG.error("缓存对象为空，无法从缓存中读取数据！ key=" + key);
			return null;
		}

		Element element = this.cache.get(key);
		if (null != element)
		{
			Object obj = element.getObjectValue();
			if (obj instanceof User)
			{
				return (User) obj;
			}
		}
		LOG.error("缓存数据成功！- key=" + key);

		return null;
	}
}
