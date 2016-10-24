package com.bjsxt.model;

import java.util.Collection;
import java.util.Comparator;

import org.apache.commons.collections.CollectionUtils;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils.Collections;

public class User
{
	int Id;
	String name;

	public int getId()
	{
		return Id;
	}

	public void setId(int id)
	{
		Id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	/**
	 * Collections.sort(user1,user2);
	 */
	private Comparator<User> compare = new Comparator<User>()
	{
		@Override
		public int compare(User u1, User u2)
		{
			if (u1.Id != u2.Id)
			{
				return u1.Id - u2.Id;
			} else
			{
				return u1.name.compareTo(u2.name);
			}
		}
	};

}
