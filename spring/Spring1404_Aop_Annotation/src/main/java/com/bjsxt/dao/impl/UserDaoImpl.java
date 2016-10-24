package com.bjsxt.dao.impl;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;

@Component
public class UserDaoImpl implements UserDao
{

	@Override
	public int save(User user)
	{
		System.out.println("user saved!");
		return 0;
	}

	@Override
	public int delete()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
