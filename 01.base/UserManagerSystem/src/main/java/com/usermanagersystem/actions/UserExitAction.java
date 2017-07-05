package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class UserExitAction extends ActionSupport 
{
	public String execute()
	{
		ActionContext.getContext().getSession().remove("user");
		return "success";
	}

}
