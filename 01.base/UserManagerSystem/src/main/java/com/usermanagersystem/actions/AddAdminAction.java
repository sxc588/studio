package com.usermanagersystem.actions;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;
import com.usermanagersystem.entity.User;

public class AddAdminAction extends ActionSupport
{
	private static Logger loger = LoggerFactory.getLogger(AddAdminAction.class);
	
	private User admin;
	UserMapper interUser = new UserDao();

	public String execute()
	{
		admin.setRoleId(1);
		interUser.addAdmin(admin);
		List alladminList = interUser.findAllAdmins();
		if (ActionContext.getContext().getSession().containsKey("alladminList"))
		{
			ActionContext.getContext().getSession().remove("alladminList");
		}
		ActionContext.getContext().getSession().put("alladminList", alladminList);
		return "success";
	}

	@Override
	public void validate()
	{
		boolean flag = interUser.isExistUsername(admin.getUsername());
		if (flag)
		{
			this.addFieldError("addadminerr", "添加管理员失败！用户名已存在");
		}
	}

	public User getAdmin()
	{
		return admin;
	}

	public void setAdmin(User admin)
	{
		this.admin = admin;
	}

}
