package com.github.support.mvc;

import java.io.IOException;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

@SuppressWarnings("serial")
public class I18nTag extends TagSupport
{
	private static final String KEY_LANG = "lang";

	private String key;

	@Override
	public int doStartTag() throws JspException
	{

	//	String lang = this.pageContext.getSession().getAttribute(KEY_LANG).toString();

		try
		{
			//String langValue = I18nCacheService.getI18nValue(lang, key);
			super.pageContext.getOut().write("langValue");
		}
		catch (IOException e)
		{
			throw new JspException(e);
			// e.printStackTrace();
		}
		return super.doStartTag();
	}

	/**
	 * @param key
	 *            the key to set
	 */
	public void setKey(String key)
	{
		this.key = key;
	}

}