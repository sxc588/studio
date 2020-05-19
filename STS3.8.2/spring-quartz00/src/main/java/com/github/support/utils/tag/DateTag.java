package com.github.support.utils.tag;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 代属性的标签
 *
 */
public class DateTag extends TagSupport
{
	private static final long serialVersionUID = 1L;

	private String pattern = "yyyy-MM-dd hh:mm:ss";
	private Date date;

	// 必须要有Set方法，因为是属性可以设值
	public void setPattern(String pattern)
	{
		this.pattern = pattern;
	}

	public void setDate(Date date)
	{
		this.date = date;
	}

	@Override
	public int doEndTag() throws JspException
	{
		SimpleDateFormat sdf = new SimpleDateFormat(pattern);
		// 如果没有就是当前时间
		if (date == null)
		{
			date = new Date();
		}
		JspWriter out = pageContext.getOut();

		try
		{
			out.print(sdf.format(date));
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return TagSupport.EVAL_PAGE;
	}
}
