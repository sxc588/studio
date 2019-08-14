package com.usermanagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.dao.UserDao;
import com.usermanagersystem.dao.UserMapper;

public class AdminDeleteUserAction extends ActionSupport
{
	private int id;
	private String tip;// 提示用户信息

	UserMapper interUser = new UserDao();
	List alluserList = interUser.findAllUsers();

	public String execute()
	{
		UserMapper interUser = new UserDao();
		int count = interUser.deleteUser(id);// 根据id删除指定用户
		if (count != 0)
		{
			this.setTip("删除普通用户成功");
			if (ActionContext.getContext().getSession().containsKey("alluserList"))
			{
				ActionContext.getContext().getSession().remove("alluserList"); // 从session中删除alluserList
			}
			ActionContext.getContext().getSession().put("alluserList", alluserList);// 将新数据放到session中

		} else
		{
			this.setTip("删除普通用户失败");
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
