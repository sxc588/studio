package org.fkjava.action;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

public class BaseAcion extends ActionSupport implements ServletContextAware, ServletRequestAware, ServletResponseAware, SessionAware,CookiesAware
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ServletContext application; // Servlet上下文
	public HttpServletRequest request; // request对象
	public HttpServletResponse response; // response对象
	public Map<String, Object> session; // session对象

	public Map<String, String> cookies;

	@Override
	public String execute() throws Exception
	{
		ActionContext actionContext = ActionContext.getContext();
		Map<String, Object> session = actionContext.getSession();
		session.put("USER_NAME", "Test User");
		return SUCCESS;
	}

	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}

	@Override
	public void setServletResponse(HttpServletResponse response)
	{
		this.response = response;
	}

	@Override
	public void setServletRequest(HttpServletRequest request)
	{
		this.request = request;
	}

	@Override
	public void setServletContext(ServletContext application)
	{
		this.application = application;
	}

	@Override
	public void setCookiesMap(Map<String, String> cookie)
	{
		this.cookies = cookie;
		
	}
}
