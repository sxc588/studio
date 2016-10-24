package com.bjsxt.service;

import java.lang.reflect.Proxy;

import org.junit.Test;

import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl;
import com.bjsxt.model.User;

public class UserServiceTest
{

	@Test
	public void testSave()
	{
		UserService service = new UserService();

		//
		User user = new User();
		service.save(user);
		// UserDao userDao = new UserDao();
	}

	@Test
	public void testProxy()
	{
		UserDao service = new UserDaoImpl();

		LogInterceptor li = new LogInterceptor(service);

		UserDao proxy = (UserDao) Proxy.newProxyInstance(service.getClass().getClassLoader(),
				service.getClass().getInterfaces(), li);

		UserDao proxy2 = (UserDao) Proxy.newProxyInstance(service.getClass().getClassLoader(), new Class[]
		{ UserDao.class }, li);
		User user = new User();
		proxy.save(user);
		proxy2.save(user);
		
		proxy.delete();
		proxy2.delete();
		
		System.out.println(proxy.getClass());
		System.out.println(proxy.getClass().getInterfaces());
	}

}
