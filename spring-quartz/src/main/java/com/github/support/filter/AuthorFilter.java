package com.github.support.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.github.support.service.UserService;

public class AuthorFilter implements Filter
{
	private static final Logger logger = LoggerFactory.getLogger(AuthorFilter.class);

	private String[] exclusions = null;

	@Override
	public void init(FilterConfig filterConfig) throws ServletException
	{
		logger.info("init method.");

		String ecelusionString = filterConfig.getInitParameter("exclusions");

		if (StringUtils.isNotBlank(ecelusionString))
		{
			exclusions = ecelusionString.split(",");
		}
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterchain)
			throws IOException, ServletException
	{
		HttpServletRequest httpRequet = (HttpServletRequest) request;
		HttpServletResponse httpResponse = (HttpServletResponse) response;

		try
		{
			checkPermission(httpRequet, httpResponse, filterchain);

		} catch (Exception e)
		{
			e.printStackTrace();
			logger.error("check the user permission error!" + e);
		}

	}

	private void checkPermission(HttpServletRequest request, HttpServletResponse response, FilterChain filterchain)
			throws Exception
	{
		String url = request.getRequestURL().toString();

		if (isExclusion(url))
		{
			filterchain.doFilter(request, response);
			return;
		}
		logger.info("url:" + url);

		HttpSession session = request.getSession();

		Object uidBean = session.getAttribute("_SESSION_USERINFO_BEAN");

		String uid = uidBean == null ? "anonymous" : "loginuser";

		// 匿名用户，跳转到登录页面
		if (StringUtils.isBlank(uid))
		{
			String loginUrl = "loginServlet" + "&redirect=" + url;
			response.sendRedirect(loginUrl);
			return;
		}

		ApplicationContext context = WebApplicationContextUtils
				.getWebApplicationContext(request.getSession(false).getServletContext());

		UserService uservice = context.getBean(UserService.class);

		boolean canlogin = uservice.canLogin(uid);

		if (canlogin)
		{
			// 有权限访问，跳过
			filterchain.doFilter(request, response);
			logger.info("user check permission ok!{}", uid);
			return;
		} else
		{
			// 无权限访问
			response.sendRedirect(request.getContextPath() + "/WEB-INF/403.jsp");
		}
	}

	private boolean isExclusion(String url)
	{
		for (String exclusion : exclusions)
		{
			if (url.matches(exclusion.replaceAll("\\*", "\\.\\*")))
			{
				return true;
			}
		}
		return false;
	}

	@Override
	public void destroy()
	{
		logger.info("destroy method.");
	}
}
