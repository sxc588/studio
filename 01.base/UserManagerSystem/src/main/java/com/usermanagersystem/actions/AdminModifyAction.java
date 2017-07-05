package com.usermanagersystem.actions;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;
public class AdminModifyAction extends ActionSupport 
{
	private User userinfo;
	public User getUserinfo() {
		return userinfo;
	}
	public void setUserinfo(User userinfo) {
		this.userinfo = userinfo;
	}
	public String execute()
	{
		InterUser interuser=new ImplUser();
		System.out.println(userinfo.getId());
		int id=interuser.getUserid(userinfo.getUsername(),userinfo.getPassword());//根据用户名和密码查找用户的id
		userinfo.setId(id);
		userinfo.setRoleId(1);	
		interuser.modifyUserInfo(userinfo);
		return "success";
	}
}
