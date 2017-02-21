package com.huawei.support.enterprise.web.action;

import com.opensymphony.xwork2.Action;

public class LoginAction20 implements Action
{
	private String username;
	private String userpassword;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserpassword()
	{
		return userpassword;
	}

	public void setUserpassword(String userpassword)
	{
		this.userpassword = userpassword;
	}

	@Override
	public String execute()
	{
		System.out.println("我进来了呢");
		System.out.println(this.getUsername());
		System.out.println(this.getUserpassword());
		if ("liping".equals(this.getUsername()) & "123456".equals(this.getUserpassword()))
		{
			return "succ";
		}
		else
		{
			return "fail";
		}
	}

}
