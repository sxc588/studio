package org.fkjava.action;

import java.util.Map;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.struts2.interceptor.ApplicationAware;
import org.apache.struts2.interceptor.CookiesAware;
import org.apache.struts2.interceptor.ServletRequestAware;
import org.apache.struts2.interceptor.ServletResponseAware;
import org.apache.struts2.interceptor.SessionAware;
import org.apache.struts2.util.ServletContextAware;
import com.opensymphony.xwork2.ActionSupport;

public class ActionBase extends ActionSupport
		implements
			ApplicationAware,
			SessionAware,
			ServletContextAware,
			CookiesAware,
			ServletRequestAware,
			ServletResponseAware
{
	private static final long serialVersionUID = -861027476955197480L;

	protected ServletContext application; // Servlet上下文
	protected HttpServletRequest request; // request对象
	protected HttpServletResponse response; // response对象
	protected Map<String, Object> session; // session对象
	protected Map<String, String> cookies;
	protected Map<String, Object> applicationMap;

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
	public void setCookiesMap(Map<String, String> cookies)
	{
		this.cookies = cookies;
	}
	@Override
	public void setServletContext(ServletContext application)
	{
		this.application = application;
	}
	@Override
	public void setSession(Map<String, Object> session)
	{
		this.session = session;
	}
	@Override
	public void setApplication(Map<String, Object> applicationMap)
	{
		this.applicationMap = applicationMap;
	}
}
