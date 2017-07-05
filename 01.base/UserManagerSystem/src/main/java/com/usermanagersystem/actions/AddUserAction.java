package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class AddUserAction extends ActionSupport 
{

	private User user;//声明User对象，用于接收表单数据
	InterUser interUser=new ImplUser();
	public String execute()
	{
		
		user.setRoleId(0);//设置权限roleId等于0
		int count=interUser.addUser(user);//向数据库中添加数据
		if(count>0){
	    	return "success";
		}
		return "input";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	@Override
	public void validate()
	{
		boolean flag=interUser.isExistUsername(user.getUsername());
		if(flag)
		{
			this.addFieldError("addusererr", "添加普通用户失败！用户名已存在");
		}
	}

}
