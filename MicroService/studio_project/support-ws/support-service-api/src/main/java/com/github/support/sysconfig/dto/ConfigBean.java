package com.github.support.sysconfig.dto;

import java.util.Date;

public class ConfigBean
{
	private String key;
	private String value;
	private String parentKey;
	private String description;
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
	public String getValue()
	{
		return value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getParentKey()
	{
		return parentKey;
	}
	public void setParentKey(String parentKey)
	{
		this.parentKey = parentKey;
	}
	public String getDescription()
	{
		return description;
	}
	public void setDescription(String description)
	{
		this.description = description;
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
