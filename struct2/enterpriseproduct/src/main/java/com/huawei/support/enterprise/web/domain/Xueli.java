package com.huawei.support.enterprise.web.domain;

public class Xueli
{
	
	public Xueli()
	{
		super();
		// TODO Auto-generated constructor stub
	}
	public Xueli(String id, String name, String desc)
	{
		super();
		this.id = id;
		this.name = name;
		this.desc = desc;
	}
	String id;
	public String getId()
	{
		return id;
	}
	public void setId(String id)
	{
		this.id = id;
	}
	public String getName()
	{
		return name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDesc()
	{
		return desc;
	}
	public void setDesc(String desc)
	{
		this.desc = desc;
	}
	String name;
	String desc;

}
