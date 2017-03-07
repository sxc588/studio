package com.github.support.entitlement.entity;

public class User
{
	float userage;
	String useremail;
	String userid;
	String username;
	public User()
	{
		super();
	}
	
	
	public User(String userid, String username,float userage)
	{
		super();
		this.userage = userage;
		this.userid = userid;
		this.username = username;
	}


	public float getUserage()
	{
		return userage;
	}
	public void setUserage(float userage)
	{
		this.userage = userage;
	}
	public String getUseremail()
	{
		return useremail;
	}
	public void setUseremail(String useremail)
	{
		this.useremail = useremail;
	}
	public String getUserid()
	{
		return userid;
	}
	public void setUserid(String userid)
	{
		this.userid = userid;
	}
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
}
