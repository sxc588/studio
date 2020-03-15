package com.github.smoken.test;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.support.service.redis.RedisService;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-redis.xml" }) // 加载配置文件
public class RedisTest
{

	@Autowired
	private RedisService redisService;

	@Autowired
	private ApplicationContext context;

	@Test
	public void testExpire()
	{
		assertNotNull("scheduler not allowd null.", redisService);

		redisService.set("DDD", "SinAlph");
		String value = (String) redisService.get("DDD");

		System.out.println("-->" + value);
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
