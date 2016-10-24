package com.bjsxt.dao.impl;

import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;

/**
 * 
 * 继承
 *
 */
public class UserDaoImpl2 extends UserDaoImpl
{
	
	@Override
	public int save(User user)
	{
		System.out.println("UserDaoImpl2->user start!");
		super.save(user);
		System.out.println("UserDaoImpl2->user end!");
		return 0;
	}

}
