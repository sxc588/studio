package com.huawei.supportd.utils.scm.model;

import java.io.Serializable;

public class Emp implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 8597202257885922939L;

	private String id;
	private String name;
	private String sex;
	private int age;
	private String phone;

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

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

}
