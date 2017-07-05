package com.github.support.cbb.ehcache;

import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.MessageListener;
import org.apache.activemq.command.ActiveMQMapMessage;
import org.apache.activemq.command.ActiveMQObjectMessage;
import org.apache.activemq.util.GenerateJDBCStatements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.support.cbb.enums.jms.CacheEvent;
import com.mchange.v2.async.StrandedTaskReporting;
import net.sf.ehcache.Cache;
import net.sf.ehcache.Element;


public class JMSMessageListener implements MessageListener
{
	
	
	private SupportEhCacheManager cacheManager;
	
	Logger LOG = LoggerFactory.getLogger(JMSMessageListener.class);

	@Override
	public void onMessage(Message message)
	{
	try
	{
		handlerMessage(message);
	}
	catch (JMSException e)
	{
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	}

	private void handlerMessage(Message message) throws JMSException
	{
		//ActiveMQObjectMessage objMessage = (ActiveMQObjectMessage) message;
		//ActiveMQMapMessage mapMessagae = (ActiveMQMapMessage) message;
		MapMessage map = (MapMessage)message;
		String key = map.getString("stock");
		String value = map.getString("price");
		String cacheName = map.getString("price");
		
		SuppotEhcache cache = cacheManager.getCache(cacheName);
		int type = map.getInt("Type");
		
		LOG.info("received message type is{}" , new Object[]{type});

		switch (type)
		{
			case CacheEvent.PUT:
				LOG.info(String.format("puts element to cache--key:%s; value:%s" , key,value));
				Element element = new Element(key,value);
				cache.getNativeCache().put(element );
				break;
			case CacheEvent.UPDATE:
				LOG.info(String.format("update element to cache--key:%s; value:%s" , key,value));
				Element element2 = new Element(key,value);
				cache.getNativeCache().put(element2 );
				break;
			case CacheEvent.REMOVE:
				LOG.info(String.format("remove element to cache--key:%s" , key));
				cache.getNativeCache().remove(key );
				break;
			case CacheEvent.EXPTRE:
				LOG.info(String.format("expire element by key--key:%s;" , key));
				break;
				default:
					break;
		}
		
		

		
		
		
		
		
		
		
	}

}
