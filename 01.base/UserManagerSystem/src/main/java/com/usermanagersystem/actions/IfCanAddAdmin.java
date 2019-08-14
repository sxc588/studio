package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.entity.User;

public class IfCanAddAdmin extends ActionSupport
{
	private String tip;

	public String execute()
	{
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoleId() == 0)
		{
			this.setTip("当前用户为普通用户,请以超级管理员身份登录完成所需功能");
			return "failure";
		} else if (user.getRoleId() == 1)
		{
			this.setTip("当前用户为管理员,请以超级管理员身份登录完成所需功能");
			return "failure";
		}
		return "success";
	}

	public String getTip()
	{
		return tip;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}
}
