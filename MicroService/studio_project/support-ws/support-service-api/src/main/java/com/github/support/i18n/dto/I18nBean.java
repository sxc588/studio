package com.github.support.i18n.dto;

import java.util.Date;


public class I18nBean
{
	private String key;
	private String lang;
	private String content;
	private String lastUpdateBy;
	private Date lastUpdateTtime;
	private Date careteTtime;
	public String getKey()
	{
		return key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getLang()
	{
		return lang;
	}
	public void setLang(String lang)
	{
		this.lang = lang;
	}
	public String getContent()
	{
		return content;
	}
	public void setContent(String content)
	{
		this.content = content;
	}
	public String getLastUpdateBy()
	{
		return lastUpdateBy;
	}
	public void setLastUpdateBy(String lastUpdateBy)
	{
		this.lastUpdateBy = lastUpdateBy;
	}
	public Date getLastUpdateTtime()
	{
		return lastUpdateTtime;
	}
	public void setLastUpdateTtime(Date lastUpdateTtime)
	{
		this.lastUpdateTtime = lastUpdateTtime;
	}
	public Date getCareteTtime()
	{
		return careteTtime;
	}
	public void setCareteTtime(Date careteTtime)
	{
		this.careteTtime = careteTtime;
	}
}
