package com.bjsxt.service;

import com.bjsxt.dao.UserDao;
import com.bjsxt.dao.impl.UserDaoImpl2;
import com.bjsxt.dao.impl.UserDaoImpl3;
import com.bjsxt.dao.impl.UserDaoImpl4;
import com.bjsxt.model.User;

public class UserService
{
	UserDao userDao = new UserDaoImpl4();
	public int save(User user)
	{
		userDao.save(user);
		return 0;
	}

}
