package com.glen.Ehcache;

import java.io.Serializable;

public class SysConfig implements Serializable
{


	public SysConfig(String key, String value)
	{
		super();
		this.key = key;
		this.value = value;
	}
	public SysConfig()
	{
		super();
	}
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
	/**
	 * 
	 */
	private static final long serialVersionUID = 20160805L;
	private String key;
	private String value;

}
