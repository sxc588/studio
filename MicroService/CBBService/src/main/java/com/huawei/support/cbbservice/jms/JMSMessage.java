package com.huawei.support.cbbservice.jms;

import java.io.Serializable;

public class JMSMessage implements Serializable
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 978578308345568187L;

	
	String message;
	public void setMessage(String message)
	{
		this.message =message;
		
	}
}
