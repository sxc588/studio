package com.bjsxt.service;

import org.junit.Test;

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

}
