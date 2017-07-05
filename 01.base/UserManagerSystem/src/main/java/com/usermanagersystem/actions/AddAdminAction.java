package com.usermanagersystem.actions;

import java.util.List;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class AddAdminAction extends ActionSupport
{
	private User admin;
	InterUser interUser=new ImplUser();
	public String execute()	{
		admin.setRoleId(1);	
		interUser.addAdmin(admin);
	    List alladminList=interUser.findAllAdmins();
	    if(ActionContext.getContext().getSession().containsKey("alladminList"))
	    {
		ActionContext.getContext().getSession().remove("alladminList");
		}
		ActionContext.getContext().getSession().put("alladminList",alladminList);
	    return "success";
	}
	@Override
	public void validate()
	{
		boolean flag=interUser.isExistUsername(admin.getUsername());
		if(flag)
		{
			this.addFieldError("addadminerr", "添加管理员失败！用户名已存在");
		}
	}
	
	public User getAdmin() {
		return admin;
	}

	public void setAdmin(User admin) {
		this.admin = admin;
	}

}
