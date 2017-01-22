package org.fkjava.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.fkjava.domain.User;
import org.springframework.stereotype.Service;

@Service
public class UserService
{
	static List<User> userDb;
	static {
		
		userDb = new ArrayList<User>();
		userDb.add(new User("99137026","sunxiaochao","sxc",86.8f,new Date()));
		userDb.add(new User("99137027","songjie","sj",76.8f,new Date()));
		userDb.add(new User("99137029","niaoxiang","nx",79.8f,new Date()));
	}

	public User validateLoin(User user)
	{
		for (User usr:userDb)
		{
			if (usr.equals(user))
			{
				return usr;
			}
		}
		return null;
	}
}
