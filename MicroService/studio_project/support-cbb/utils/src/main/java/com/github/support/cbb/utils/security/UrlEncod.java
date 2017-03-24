package com.github.support.cbb.utils.security;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class UrlEncod
{

	String abcd()
	{
		try
		{
			URLEncoder.encode("a", "DDF");
		}
		catch (UnsupportedEncodingException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";

	}

}
