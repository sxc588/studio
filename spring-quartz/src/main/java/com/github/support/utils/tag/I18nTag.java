package com.github.support.utils.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

public class I18nTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String key;

	private Map<String, String> i18n = new ConcurrentHashMap<String, String>();

	@Override
	public int doStartTag() throws JspException
	{

		// HttpSession session = this.pageContext.getSession();
		// String lang = (String) session.getAttribute("lang");
		try
		{
			// String value = i18n.get(key);
			super.pageContext.getOut().write("I18n: " + key + ";time:" + format.format(new Date()));

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	public String getKey()
	{
		return key;
	}

	public void setKey(String key)
	{
		this.key = key;
	}

}
