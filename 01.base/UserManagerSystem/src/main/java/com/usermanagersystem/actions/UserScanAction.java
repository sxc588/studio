package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class UserScanAction extends ActionSupport 
{
	private int id;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	private User userinfo;
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public String execute()
	{
		InterUser interUser=new ImplUser();
	    User user=(User)ActionContext.getContext().getSession().get("user");
	    if(id!=0)
	    {
	    	this.setUserinfo(interUser.selectUserInfo(id));
	    }
	    else
	    {
	    	this.setUserinfo(user);
	    }
	    
		return "success";
	
	}

}
