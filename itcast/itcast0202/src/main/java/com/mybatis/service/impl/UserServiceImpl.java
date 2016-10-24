package com.mybatis.service.impl;

import org.springframework.stereotype.Service;
import com.mybatis.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService
{

	@Override
	public int test()
	{
		return 123;
	}

}
