package com.bjsxt.service.impl;

import javax.annotation.Resource;
import org.springframework.stereotype.Component;
import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;
import com.bjsxt.service.UserService;

@Component
public class UserServiceImpl implements UserService
{
	@Resource(name = "userDaoImpl")
	UserDao userDao;

	@Override
	public void save(User user)
	{
		userDao.save(user);

	}

}
