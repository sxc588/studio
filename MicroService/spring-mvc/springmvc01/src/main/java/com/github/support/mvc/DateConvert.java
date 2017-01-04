package com.github.support.mvc;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 数据类型转换
 * 
 * @author LiDuanqiang
 * 
 */
@SuppressWarnings("serial")
public class DateConvert extends TagSupport
{
	private String longTime;

	@Override
	public int doStartTag() throws JspException
	{
		long l = 0l;
		if (longTime != null && !longTime.equals(""))
		{
			l = Long.parseLong(longTime);
		}
		Date date = new Date(l);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String targetTime = format.format(date);
		try
		{
			super.pageContext.getOut().write(targetTime);
		}
		catch (IOException e)
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