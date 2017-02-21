package com.huawei.support.enterprise.web.action;

import com.opensymphony.xwork2.Action;

public class LoginAction21 implements Action
{
	@Override
	public String execute()
	{
		System.out.println("退出系统");
		return "exit";
	}
}
