package com.usermanagersystem.actions;

import java.util.List;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;
import com.usermanagersystem.entity.User;

public class AdminDeleteAdminAction extends ActionSupport
{
	private int id;
	private String tip;

	public String execute()
	{
		UserMapper interuser = new UserDao();
		int count = interuser.deleteUser(id);// 删除指定用户id的用户
		if (count != 0)
		{
			List alladminList = interuser.findAllAdmins();
			ActionContext.getContext().getSession().remove("alladminList");
			ActionContext.getContext().getSession().put("alladminList", alladminList);
			this.setTip("删除普通管理员成功！");
		} else
		{
			this.setTip("删除普通管理员失败！");
		}
		return "success";
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
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
