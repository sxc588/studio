package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;
import com.usermanagersystem.entity.User;

public class UserModifyAction extends ActionSupport
{
	private User userinfo;

	public String execute()
	{
		UserMapper interuser = new UserDao();
		int id = interuser.getUserid(userinfo.getUsername(), userinfo.getPassword());// 通过用户名和密码查找用户的id
		int roleid = interuser.getUserroleId(id);// 根据id查找对象的roleId
		userinfo.setId(id);
		userinfo.setRoleId(roleid);
		int count = interuser.modifyUserInfo(userinfo);// 调用modifyUserInfo()方法实现修改用户信息
		if (count > 0)
		{
			return "success";
		} else
		{
			return "error";
		}

	}

	public User getUserinfo()
	{
		return userinfo;
	}

	public void setUserinfo(User userinfo)
	{
		this.userinfo = userinfo;
	}
}
