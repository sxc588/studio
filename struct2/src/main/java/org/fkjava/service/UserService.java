package org.fkjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import org.fkjava.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	static List<User> userDb;
	static
	{
		userDb = new ArrayList<User>();
		userDb.add(new User("99137025", "zhangjian", "sxc", 86.8f, new Date()));
		userDb.add(new User("99137026", "sunxiaochao", "sxc", 86.8f, new Date()));
		userDb.add(new User("99137027", "songjie", "sj", 76.8f, new Date()));
		userDb.add(new User("99137029", "niaoxiang", "nx", 79.8f, new Date()));
	}

	/**
	 * 用户登录验证，登录成功， 返回数据酷用户的信息
	 * 
	 * @param user
	 * @return
	 */
	public User validateLogin(User user)
	{
		for (User usr : userDb)
		{
			if (usr.equals(user))
			{
				return usr;
			}
		}
		return null;
	}

	public User add(User user)
	{
		Integer id = new Random().nextInt(999999);
		user.setId(id.toString());
		userDb.add(user);
		
		return user;
	}

	public List<User> getAll()
	{
		return userDb;
	}

	public User validateUser(String userName)
	{
		for (User usr : userDb)
		{
			if (usr.getName().equalsIgnoreCase(userName))
			{
				return usr;
			}
		}
		return null;
	}
}
