package com.github.smoken.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.quartz.Scheduler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.scheduling.quartz.SchedulerFactoryBean;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-quartz.xml" }) // 加载配置文件
public class SchedulerFactoryTest
{

	@Autowired
	private SchedulerFactoryBean scheduler;

	@Autowired
	private ApplicationContext context;

	@Test
	public void testExpire()
	{
		Scheduler ggBean = scheduler.getScheduler();
		assertNotNull("scheduler not allowd null.", ggBean);
	}

	@Test
	public void enumContext()
	{
		String[] beanNames = context.getBeanDefinitionNames();

		System.out.println("--------------------------------------");
		System.out.println(JSON.toJSON(beanNames));

		for (String beanName : beanNames)
		{
			String type = context.getBean(beanName).getClass().getName();

			System.out.println(beanName + " -> " + type);
		}
		System.out.println("--------------------------------------");
	}

}
