package com.github.support.demo;

import java.util.ArrayList;
import java.util.List;
import com.github.support.entitlement.entity.User;

public class HelloWordImpl implements HelloWorld
{

	@Override
	public String say(String name)
	{
		return name + "，您好！";
	}

	@Override
	public String sayHello(User user)
	{
		return user.getUsername() + "，您好！";
	}

	@Override
	public List<User> getList(Long id)
	{
		List<User> list = new ArrayList<User>();

		Long sid = 1L;
		User user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);

		sid = 2L;
		user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);

		sid = 3L;
		user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);
		return list;
	}

}
