package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.entity.User;

public class IfCanAddUser extends ActionSupport
{
	private String tip;

	public String getTip()
	{
		return tip;
	}

	public void setTip(String tip)
	{
		this.tip = tip;
	}

	public String execute()
	{
		User user = (User) ActionContext.getContext().getSession().get("user");
		if (user.getRoleId() == 0)
		{
			this.setTip("普通用户不具备添加新用户的权限");
			return "failure";
		} else
		{
			return "success";
		}
	}
}
