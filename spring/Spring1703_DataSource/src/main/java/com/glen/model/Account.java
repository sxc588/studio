package com.glen.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="Account")  
public class Account implements Serializable
{

	private static final long serialVersionUID = -7970848646314840509L;
	
	private Integer accountId;
	private String username;
	private String password;
	private Date createTime;
	/**
	 * @return the accountId
	 */
	public Integer getAccountId()
	{
		return accountId;
	}
	/**
	 * @param accountId the accountId to set
	 */
	public void setAccountId(Integer accountId)
	{
		this.accountId = accountId;
	}
	/**
	 * @return the username
	 */
	public String getUsername()
	{
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username)
	{
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword()
	{
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password)
	{
		this.password = password;
	}
	/**
	 * @return the createTime
	 */
	public Date getCreateTime()
	{
		return createTime;
	}
	/**
	 * @param createTime the createTime to set
	 */
	public void setCreateTime(Date createTime)
	{
		this.createTime = createTime;
	}


}