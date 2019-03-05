package com.github.support.dbaccess.dto;

import java.io.Serializable;
import java.util.Date;

public class ConfigDto implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String key;
	private String value;
	private String description;

	private String lastUpdateBy;
	private Date lastUpdateTime;
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
	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}
	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}
}
