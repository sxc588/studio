package com.github.support.utils.tag;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 最简单的标签
 *
 */
public class LangHuaTag extends TagSupport
{
	private static final long serialVersionUID = 1L;

	private long startTime;

	private long endTime;

	@Override
	public int doStartTag() throws JspException
	{
		startTime = System.currentTimeMillis();
		// 表示定制标记里面有所包括的JSP页面
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doEndTag() throws JspException
	{
		endTime = System.currentTimeMillis();
		long elapsed = endTime - startTime;
		try
		{
			JspWriter out = pageContext.getOut();
			out.println("runtime is " + elapsed);
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		// 表示JSP页面继续运行
		return TagSupport.EVAL_PAGE;
	}
}
