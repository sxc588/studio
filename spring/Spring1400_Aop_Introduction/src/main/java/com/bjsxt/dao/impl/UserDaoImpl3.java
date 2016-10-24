package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;

/**
 * 组合
 *
 */
public class UserDaoImpl3 implements UserDao
{
	UserDao userDaoImpl = new UserDaoImpl2();
	
	@Override
	public int save(User user)
	{
		System.out.println("UserDaoImpl3->user start!");
		userDaoImpl.save(user);
		System.out.println("UserDaoImpl3->user end!");
		return 0;
	}

}
