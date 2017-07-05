package com.github.support.dsdp.config;

import java.util.Date;

public class DSDPConfig
{
	String key;
	String value;
	String parent;
	String description;
	String last_update_by;
	Date last_update_time;
	public String getKey()
	{
		return this.key;
	}
	public void setKey(String key)
	{
		this.key = key;
	}
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public String getParent()
	{
		return this.parent;
	}
	public void setParent(String parent)
	{
		this.parent = parent;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getLast_update_by()
	{
		return this.last_update_by;
	}
	public void setLast_update_by(String last_update_by)
	{
		this.last_update_by = last_update_by;
	}
	public Date getLast_update_time()
	{
		return this.last_update_time;
	}
	public void setLast_update_time(Date last_update_time)
	{
		this.last_update_time = last_update_time;
	}
}
