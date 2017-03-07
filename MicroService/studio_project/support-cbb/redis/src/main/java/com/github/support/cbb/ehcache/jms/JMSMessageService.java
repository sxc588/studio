package com.github.support.cbb.ehcache.jms;

import java.util.Map;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.ObjectMessage;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

@Service
public class JMSMessageService
{
	@Autowired
	JmsTemplate jmsTemplate;

	public void sendMessage(Destination destination, final String message)
	{
		MessageCreator messageCreator = new MessageCreator()
		{
			@Override
			public Message createMessage(Session session) throws JMSException
			{
				TextMessage textMessage = session.createTextMessage(message);
				return textMessage;
			}
		};
		jmsTemplate.send(destination, messageCreator);
	}

	private String topicName = "queue";

	private Topic topic;

	public void setJmsTemplate(JmsTemplate jmsTemplate)
	{
		this.jmsTemplate = jmsTemplate;
	}

	public void setTopicName(String topicName)
	{
		this.topicName = topicName;
	}

	public void sendMessage(final String message)
	{
		try
		{
			if (topic == null)
			{
				topic = jmsTemplate.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic(topicName);
			}

			jmsTemplate.send(topic, new MessageCreator()
			{
				@Override
				public Message createMessage(Session session) throws JMSException
				{
					TextMessage textMessage = session.createTextMessage(message);
					return textMessage;
				}
			});
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}
	}

	public void sendMessage(final Map<String, Object> message)
	{
		try
		{
			if (topic == null)
			{
				topic = jmsTemplate.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic(topicName);
			}

			jmsTemplate.send(topic, new MessageCreator()
			{
				@Override
				public Message createMessage(Session session) throws JMSException
				{
					MapMessage textMessage = session.createMapMessage();
					// textMessage.setObject(name, value);
					return textMessage;
				}
			});
		}
		catch (JMSException e)
		{
			e.printStackTrace();
		}
	}

	public Destination createQueue(String queueName) throws JMSException
	{

		Destination topic = jmsTemplate.getConnectionFactory().createConnection().createSession(false, Session.AUTO_ACKNOWLEDGE).createTopic(queueName);
		return topic;
	}

	public void sendMessage(Destination queue, final JMSMessage msg)
	{
		jmsTemplate.send(queue, new MessageCreator()
		{
			@Override
			public Message createMessage(Session session) throws JMSException
			{
				ObjectMessage textMessage = session.createObjectMessage(msg);
				return textMessage;
			}
		});
	}
}
