package com.bjsxt.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl2;
import com.bjsxt.dao.impl.UserDaoImpl3;
import com.bjsxt.model.User;
import com.bjsxt.service.UserService;

@Component
public class UserServiceImpl implements UserService
{
	@Resource(name="userDaoImpl3")
	UserDao userDao;
	
	public void save(User user)
	{
		// throw new RuntimeException();
		 userDao.save(user);
		
		
	}

}
