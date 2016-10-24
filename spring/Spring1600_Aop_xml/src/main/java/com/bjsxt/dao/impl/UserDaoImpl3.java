package com.bjsxt.dao.impl;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;

/**
 * 组合
 *
 */
@Component
public class UserDaoImpl3 implements UserDao
{
	@Resource(name="userDaoImpl")
	UserDao userDaoImpl;
	
	@Override
	public int save(User user)
	{
		System.out.println("UserDaoImpl3->user start!");
		userDaoImpl.save(user);
		System.out.println("UserDaoImpl3->user end!");
		return 0;
	}

	@Override
	public int delete()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
