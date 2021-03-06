package com.github.support.controller.debug;

import javax.annotation.Resource;
import javax.jms.Destination;
import javax.jms.TextMessage;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.jms.ActiveMqProducerService;
import com.github.support.jms.ConsumerService;

/**
 * Created by Administrator on 2017/1/5.
 */
@Controller

@RequestMapping(value = "debug/msg")
public class MessageController
{
	// 队列消息消费者
	@Resource(name = "consumerService")
	private ConsumerService consumer;
	// @Resource(name = "demoQueueDestination")
	private Destination destination;

	private Logger logger = LoggerFactory.getLogger(MessageController.class);

	// 队列消息生产者
	@Resource(name = "activeMqProducerService")
	private ActiveMqProducerService producer;

	@RequestMapping(value = "/reeivemsg", method = RequestMethod.GET)
	@ResponseBody
	public Object receive()
	{
		System.err.println(Thread.currentThread().getName() + "------------receive from jms Start");
		TextMessage tm = consumer.receive(destination);
		System.err.println(Thread.currentThread().getName() + "------------receive from jms End");
		return tm;
	}

	@RequestMapping(value = "/sendmsg", method = RequestMethod.GET)
	@ResponseBody
	public void send(String msg)
	{
		System.err.println(Thread.currentThread().getName() + "------------send to jms Start");
		producer.sendMessage(msg);
		System.err.println(Thread.currentThread().getName() + "------------send to jms End");
	}

}