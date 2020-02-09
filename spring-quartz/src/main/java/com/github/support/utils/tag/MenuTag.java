package com.github.support.utils.tag;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class MenuTag extends TagSupport
{

	private String menuStr;

	@Override
	public int doStartTag() throws JspException
	{
		// TODO Auto-generated method stub
		HttpSession session = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest()
				.getSession();
		List<SysMenuBean> userMenus = (List<SysMenuBean>) session.getAttribute("sysMenuBeans");

		for (SysMenuBean sysMenuBean : userMenus)
		{
			try
			{
				if (sysMenuBean.getUrl() != null && sysMenuBean.getUrl().contains(menuStr))
				{
					return TagSupport.EVAL_BODY_INCLUDE;
				}
			} catch (Exception e)
			{
				// TODO Auto-generated catch block
				return TagSupport.SKIP_BODY;
			}
		}
		return TagSupport.SKIP_BODY;
	}

	public String getMenuStr()
	{
		return menuStr;
	}

	public void setMenuStr(String menuStr)
	{
		this.menuStr = menuStr;
	}

}