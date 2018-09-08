package com.github.support.vo;

import java.text.SimpleDateFormat;
import java.util.Date;

import javax.xml.crypto.Data;

import com.dexcoder.commons.pager.Pageable;

public class UserVo extends Pageable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserVo(String name, int age, int country, String address, boolean married)
	{
		super();
		Name = name;
		Age = age;
		Country = country;
		Address = address;
		Married = married;
		
		lastUpdateTime = new Date();
	}

	private String Name;
	private int Age;
	private int Country;
	private String Address;
	private boolean Married;
	
	private Date lastUpdateTime;
	
	public String getLastUpdateTimeFmt()
	{
		
		 SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		
		return sdf.format(lastUpdateTime);
	}
	
	public Date getLastUpdateTime()
	{
		return lastUpdateTime;
	}

	public void setLastUpdateTime(Date lastUpdateTime)
	{
		this.lastUpdateTime = lastUpdateTime;
	}

	public String getName()
	{
		return Name;
	}

	public void setName(String name)
	{
		Name = name;
	}

	public int getAge()
	{
		return Age;
	}

	public void setAge(int age)
	{
		Age = age;
	}

	public int getCountry()
	{
		return Country;
	}

	public void setCountry(int country)
	{
		Country = country;
	}

	public String getAddress()
	{
		return Address;
	}

	public void setAddress(String address)
	{
		Address = address;
	}

	public boolean isMarried()
	{
		return Married;
	}

	public void setMarried(boolean married)
	{
		Married = married;
	}
}
