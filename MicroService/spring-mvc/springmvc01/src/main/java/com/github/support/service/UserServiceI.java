package com.github.support.service;

import java.util.List;
import com.github.support.mybatis.entitement.model.User;

public interface UserServiceI {

	User getUserById(String id);

	List<User> getAll();

	void logIn(String username, String password);

}
