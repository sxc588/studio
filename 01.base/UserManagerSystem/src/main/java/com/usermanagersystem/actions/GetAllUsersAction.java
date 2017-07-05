package com.usermanagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class GetAllUsersAction extends ActionSupport 
{
	public String execute()
	{

		InterUser interUser=new ImplUser();
		List alluserList=interUser.findAllUsers();
		
		if(ActionContext.getContext().getSession().containsKey("alluserList"))
		{
		ActionContext.getContext().getSession().remove("alluserList");
		}//判断session中是否已存在所有用户信息集合，诺存在，删除掉
		
		ActionContext.getContext().getSession().put("alluserList",alluserList);//将新查到的数据放入session中
		User user=(User)ActionContext.getContext().getSession().get("user");
		if(user.getRoleId()==0)
		{
			return "userselect";
		}
		return "adminselect";
	}

}
