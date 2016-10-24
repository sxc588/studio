package com.bjsxt.service;

import org.junit.Test;

import com.bjsxt.model.User;

public class UserServiceTest
{

	@Test
	public void testSave()
	{
		UserService service = new UserService();

		User user = new User();
		user.setId(1);
		user.setName("name");
		service.save(user);
		// UserDao userDao = new UserDao();
	}

}
