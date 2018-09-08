package com.github.support.dto;

/**
 * User : 用户bean
 * user类：（mvc中的m，模型层）
 * 
 * @author xuejupo jpxue@travelsky.com
 * 
 *         create in 2016-3-1 下午4:23:16
 */

public class UserDto
{
	public final String getUserId()
	{
		return userId;
	}

	public final void setUserId(String userId)
	{
		this.userId = userId;
	}

	public final String getUserName()
	{
		return userName;
	}

	public final void setUserName(String userName)
	{
		this.userName = userName;
	}

	public final String getPasswd()
	{
		return passwd;
	}

	public final void setPasswd(String passwd)
	{
		this.passwd = passwd;
	}

	public final String getInfo()
	{
		return info;
	}

	public final void setInfo(String info)
	{
		this.info = info;
	}

	private String userId;

	private String userName;

	private String passwd;

	private String info;

	@Override
	public String toString()
	{
		return "用户名：\r\n" + this.userName + "用户密码：\r\n" + this.passwd + "用户的信息：\r\n" + this.info;
	}
}