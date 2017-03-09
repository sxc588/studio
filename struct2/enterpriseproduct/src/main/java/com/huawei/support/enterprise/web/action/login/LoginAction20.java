package com.huawei.support.enterprise.web.action.login;

import java.io.IOException;
import java.util.Map;
import javax.servlet.ServletException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.huawei.support.enterprise.web.action.ActionBase;
import com.huawei.support.enterprise.web.action.LoginAction;
import com.opensymphony.xwork2.Action;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class LoginAction20 extends ActionBase
{
	private static Logger logger = LoggerFactory.getLogger(LoginAction.class);
	private String username;
	private String userpassword;
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getUserpassword()
	{
		return userpassword;
	}

	public void setUserpassword(String userpassword)
	{
		this.userpassword = userpassword;
	}

	@Override
	public String execute()
	{

		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
	
		session.put(ConstentsUser.USER_ID,username);
		
		return SUCCESS;
	}

	public String logout() throws ServletException, IOException
	{
		ActionContext ctx = ActionContext.getContext();
		Map<String, Object> session = ctx.getSession();
	
		session.remove(ConstentsUser.USER_ID);
		
		//request.getRequestDispatcher("/http://www.sohu.com").forward(request, response);
		response.sendRedirect("http://www.sohu.com");
		
		return "logout";
	}
}
