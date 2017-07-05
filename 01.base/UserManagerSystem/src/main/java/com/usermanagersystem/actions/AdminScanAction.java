package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class AdminScanAction extends ActionSupport 
{
	private int id;//用于接收从页面传来的id参数
	private User userinfo;//从页面直接传递数据
	
	public String execute()
	{
		
		InterUser interUser=new ImplUser();
		this.setUserinfo(interUser.selectUserInfo(id));
	  	return "success";
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}


	public User getUserinfo() {
		return userinfo;
	}

	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}

}
