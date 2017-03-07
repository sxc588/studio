package com.github.support.entitlement.Dao;

import java.util.List;
import com.github.support.entitlement.entity.User;

public interface UserDao
{
	int insert(User user);

	User findUserById(String userid);

	List<User> findAllUser();
}
