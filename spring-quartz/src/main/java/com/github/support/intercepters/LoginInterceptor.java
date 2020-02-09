package com.github.support.intercepters;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor
{

	@Override
	public void afterCompletion(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, Exception arg3)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public void postHandle(HttpServletRequest arg0, HttpServletResponse arg1, Object arg2, ModelAndView arg3)
			throws Exception
	{
		// TODO Auto-generated method stub

	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object arg2) throws Exception
	{
		System.out.println("------LoginInterceptor-------");

		// 获取请求的URL
		String url = request.getRequestURI();
		// URL:login.jsp是公开的;这个demo是除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
		// 注意：一些静态文件不能拦截，否则会死循环，知道内存耗尽
		if (url.indexOf("login") >= 0)
		{
			return true;
		}
		// 获取Session
		HttpSession session = request.getSession();
		String username = (String) session.getAttribute("username");

		if (username != null)
		{
			return true;
		}
		// 不符合条件的，跳转到登录界面
		// request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request,
		// response);
		response.sendRedirect("/test/login");

		return false;
	}

}
