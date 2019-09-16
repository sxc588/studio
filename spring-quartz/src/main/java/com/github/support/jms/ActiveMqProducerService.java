package com.github.support.jms;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
import org.springframework.stereotype.Service;

import com.github.support.service.PerformancMatrixBean;

/**
 * Created by Administrator on 2017/1/5.
 */
@Service
public class ActiveMqProducerService {

	/* 日志对象 */
	private static final Logger LOG = LoggerFactory.getLogger(ActiveMqProducerService.class);

	@Resource(name = "jmsTemplate")
	private JmsTemplate jmsTemplate;

	@Autowired
	private PerformancMatrixBean pmb;

	public void sendMessage(Destination destination, final String msg) {
		pmb.inc();
		LOG.info("{}向队列{}发送消息：{}" + Thread.currentThread().getName(), destination.toString(), msg);

		jmsTemplate.send(destination, new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}

	public void sendMessage(final String msg) {
		String destination = jmsTemplate.getDefaultDestinationName();
		LOG.info("{}向缺省队列{}发送消息：{}", Thread.currentThread().getName(), destination, msg);
		jmsTemplate.send(new MessageCreator() {
			@Override
			public Message createMessage(Session session) throws JMSException {
				return session.createTextMessage(msg);
			}
		});
	}
}