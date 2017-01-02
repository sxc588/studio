package com.github.support.mvc.service;

import java.util.List;
import com.github.support.entitement.mybatis.model.User;


public interface UserServiceI {

	User getUserById(String id);

	List<User> getAll();

	void logIn(String username, String password);

}
