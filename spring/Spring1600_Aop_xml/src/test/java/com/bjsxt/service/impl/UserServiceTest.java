package com.bjsxt.service.impl;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.User;
import com.bjsxt.service.impl.UserServiceImpl;

/**
 *  1.权限，
 *  2.日志效率检查
 *  3.事务，try-异常管理
 *  3.随时可去
 *  4.spring 实现 jdk 动态代理
 *  概念：JoinPoint PointCut aspect
 */

public class UserServiceTest
{

	@Test
	public void testSave()
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("classpath*:spring/spring.xml");

		UserServiceImpl service = (UserServiceImpl) ctx.getBean("userService");

		User user = new User();
		service.save(user);

		ctx.destroy();
	}
}
