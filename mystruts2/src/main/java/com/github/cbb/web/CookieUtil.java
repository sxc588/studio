package com.github.cbb.web;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang3.StringUtils;

public class CookieUtil
{

	/**
	 * 从cookie 中读取 stage
	 * @param request
	 * @return
	 */
	public static String getCookieStage(final HttpServletRequest request)
	{
		String stage = StringUtils.EMPTY;
		Cookie[] cookies = request.getCookies();
		if (cookies != null)
		{
			for (Cookie cookie : cookies)
			{
				if ("stage".equals(cookie.getName()))
				{
					stage = cookie.getValue();
				}
			}
		}
		if (StringUtils.isBlank(stage))
		{
			return "Alpha";
		}
		return stage;
	}

}
