package com.github.support.aop.service.impl;

import com.github.support.aop.service.ILoginService;

//execution(* * cn.com.spring.service.impl.*.*(..))
//1)* 所有的修饰符
//2)* 所有的返回类型
//3)* 所有的类名
//4)* 所有的方法名
//5)* ..所有的参数名

public class LoginServiceImpl implements ILoginService
{

	@Override
	public boolean login(String userName, String password)
	{
		System.out.println("login:"+userName+","+password);
		return true;
	}
}
