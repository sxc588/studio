package org.crazyit.demo.action;

import com.opensymphony.xwork2.*;

/**
 * Description:
 * <br/>网站: <a href="http://www.crazyit.org">疯狂Java联盟</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
// 继承ActionSupport来实现Action
public class LoginAction extends ActionSupport
{
	//下面是用于封装用户请求参数的两个属性
	private String username;
	private String password;
	// username属性的getter和setter方法
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password属性的getter和setter方法
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	// 处理用户请求的execute方法
	public String execute() throws Exception
	{
		// 当用户请求参数的username等于crazyit，密码请求参数为leegang时，
		// 返回success字符串，否则返回error字符串
		if (getUsername().equals("crazyit")
			&& getPassword().equals("leegang"))
		{
			// 通过ActionContext对象访问Web应用的HTTP Session
			ActionContext.getContext().getSession()
				.put("user" , username);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}
