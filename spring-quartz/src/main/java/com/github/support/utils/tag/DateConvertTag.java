package com.github.support.utils.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.apache.commons.lang3.StringUtils;

public class DateConvertTag extends TagSupport
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static final SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

	private String longTime;

	@Override
	public int doStartTag() throws JspException
	{
		long l = 0l;
		if (StringUtils.isNotBlank(longTime))
		{
			l = Long.parseLong(longTime);
		}

		Date date = new Date(l);
		String targetTime = format.format(date);
		try
		{
			super.pageContext.getOut().write(targetTime);

		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return super.doStartTag();
	}

	// setter and getter
	public void setLongTime(String longTime)
	{
		this.longTime = longTime;
	}

}