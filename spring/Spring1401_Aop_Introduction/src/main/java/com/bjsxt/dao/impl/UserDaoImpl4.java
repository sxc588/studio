package com.bjsxt.dao.impl;

import com.bjsxt.aop.LogInterceptor;
import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;

/**
 * 组合
 *
 */
public class UserDaoImpl4 implements UserDao
{
	UserDao userDaoImpl = new UserDaoImpl3();
	
	@Override
	public int save(User user)
	{
		new LogInterceptor().beforMethod();
		
		userDaoImpl.save(user);

		return 0;
	}

}
