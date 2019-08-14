package com.mybatis.model;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mybatis.service.UserService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations =
{"classpath:spring/spring.xml"})
public class TestSpring
{
	
	@Autowired
	ApplicationContext ac;

	@Test
	public void test()
	{
		// 从Spring的IOC容器中获取bean对象
		UserService userService = (UserService) ac.getBean("userService");
		// 执行测试方法
		int acture = userService.test();
		assertEquals(123, acture);
	}
}
