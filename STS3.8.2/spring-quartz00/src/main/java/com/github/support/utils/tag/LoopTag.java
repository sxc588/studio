package com.github.support.utils.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

/**
 * 
 * 
 * TagSupport的流程图
 * 
 * SKIP_BODY 表示不用处理标签体，直接调用doEndTag()方法。
 * 
 * SKIP_PAGE 忽略标签后面的JSP内容。
 * 
 * EVAL_PAGE 处理标签后，继续处理JSP后面的内容。
 * 
 * EVAL_BODY_BUFFERED 表示需要处理标签体。
 * 
 * EVAL_BODY_INCLUDE 表示需要处理标签体,但绕过setBodyContent()和doInitBody()方法
 * 
 * EVAL_BODY_AGAIN 对标签体循环处理。
 *
 */
public class LoopTag extends TagSupport
{
	private static final long serialVersionUID = 1L;

	private int times = 0;

	// Set方法设值
	public void setTimes(int times)
	{
		this.times = times;
	}

	@Override
	public int doStartTag() throws JspException
	{
		// 表示定制标记里面有所包括的JSP页面
		return TagSupport.EVAL_BODY_INCLUDE;
	}

	@Override
	public int doAfterBody() throws JspException
	{
		if (times > 0)
		{
			times--;
			// 表示双从标签开始输入
			return TagSupport.EVAL_BODY_AGAIN;
		}
		// 表示结束，忽略标签内部的内容
		return TagSupport.SKIP_BODY;
	}
}
