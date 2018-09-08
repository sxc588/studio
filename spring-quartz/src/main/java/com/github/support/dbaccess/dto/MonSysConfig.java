package com.github.support.dbaccess.dto;

import java.util.Date;

import org.apache.commons.lang.StringUtils;

public class MonSysConfig
{
	public MonSysConfig()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public MonSysConfig(Integer key, String value, String description, Date lastUpdateTime, String lastUpdateBy)
	{
		super();
		this.key = key;
		this.value = value;
		this.description = description;
		this.lastUpdateTime = lastUpdateTime;
		this.lastUpdateBy = lastUpdateBy;
	}

	private Integer key;

	private String value;

	private String description;

	private Date lastUpdateTime;

	private String lastUpdateBy;

	public Integer getKey()
	{
		return key;
	}

	public void setKey(Integer key)
	{
		this.key = key;
	}

	public String getValue()
	{
		return value;
	}

	public void setValue(String value)
	{
		this.value = value == null ? null : value.trim();
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description == null ? null : description.trim();
	}

	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getLastUpdateBy()
	{
		return lastUpdateBy;
	}

	public void setLastUpdateBy(String lastUpdateBy)
	{
		
		this.lastUpdateBy =	lastUpdateBy == null ? null : lastUpdateBy.trim(); 
	}
}