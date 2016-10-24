package com.bjsxt.service;

import java.lang.reflect.Proxy;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.User;


/**
 *  1.权限，
 *  2.日志效率检查
 *  3.事务，try-异常管理
 *  3.随时可去
 *  4.spring 实现 jdk 动态代理
 *
 */

/**
 * JoinPoint
 * PointCut
 * aspect
 *
 */
public class UserServiceTest
{

	@Test
	public void testSave()
	{
		@SuppressWarnings("resource")
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring/spring.xml");
		
	 UserService service  = (UserService) ctx.getBean("userService");

	 User user = new User();
	 service.save(user);
	
	 
	 ctx.destroy();
	}

	

}
