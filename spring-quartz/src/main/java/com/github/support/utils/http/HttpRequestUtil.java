package com.github.support.utils.http;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class HttpRequestUtil
{

	public static int getParameterInteger(HttpServletRequest request, String key, int defVal)
	{
		try
		{
			String value = request.getParameter(key);
			int intVal = Integer.parseInt(value);
			return intVal;
		} 
		catch (Exception e)
		{
		
		}


		
		
		int value = request.getIntHeader(key);
		if (value>=0)
return value;
		
		return defVal;
	}

}
