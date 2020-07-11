package com.github.support.utils;

public class PtResoult
{
	public PtResoult(int code, String description, long elapse)
	{
		super();
		this.code = code;
		this.description = description;
		this.elapse = elapse;
	}

	int code;
	String description;
	long elapse;

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public long getElapse()
	{
		return elapse;
	}

	public void setElapse(long elapse)
	{
		this.elapse = elapse;
	}

}
