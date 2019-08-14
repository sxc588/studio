package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.sun.org.apache.bcel.internal.generic.RETURN;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;
import com.usermanagersystem.entity.User;

public class UserScanAction extends ActionSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private int id;

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	private User userinfo;

	public User getUserinfo()
	{
		return userinfo;
	}

	public void setUserinfo(User userinfo)
	{
		this.userinfo = userinfo;
	}

	public String execute()
	{
		UserMapper interUser = new UserDao();

		User user = (User) ActionContext.getContext().getSession().get("user");
		if (id != 0)
		{
			this.setUserinfo(interUser.selectUserInfo(id));
		} else
		{
			this.setUserinfo(user);
		}

		return "success";

	}

}
