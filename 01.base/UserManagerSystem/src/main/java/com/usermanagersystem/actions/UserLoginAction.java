package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class UserLoginAction extends ActionSupport
{
	private User user;
	private String loginerror;
	
	public String execute()
	{
		InterUser interUser=new ImplUser();
		boolean flag=interUser.login(user);//调用ImplUser类的login方法判断用户是否存在
		if(flag){
			ActionContext.getContext().getSession().put("user",user);
			return "success";
		}
		this.setLoginerror("用户名或密码输入错误");
		return "input";
	}
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	public String getLoginerror() {
		return loginerror;
	}
	public void setLoginerror(String loginerror) {
		this.loginerror = loginerror;
	}
}
