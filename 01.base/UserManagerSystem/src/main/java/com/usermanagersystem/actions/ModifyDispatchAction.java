package com.usermanagersystem.actions;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.usermanagersystem.ImplDao.ImplUser;
import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;

public class ModifyDispatchAction extends ActionSupport 
{
	private User userinfo;
	private int id;
  
	public String execute()
    {
		InterUser interuser=new ImplUser();
		User user=(User)ActionContext.getContext().getSession().get("user");
		
			if(id!=0)//id不等于0，表示当前用户不是通过单击[修改个人信息]转到此Action上
			{
			   	this.setUserinfo(interuser.selectUserInfo(id));
			   	return "othersmodify";
			}
			else//表示当前用户通过单击[修改个人信息]连接转到此Action上
			{
			this.setUserinfo(user);
			return "usermodify";
			}  	
     	
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
