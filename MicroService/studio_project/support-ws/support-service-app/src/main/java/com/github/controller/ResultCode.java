package com.github.controller;

public enum ResultCode
{

	SUCCESS(200, "200 ok"),
	SUCCESS_204(204, "204 No Conten");

	private Integer code;
	private String desc;

	ResultCode(Integer code, String desc)
	{
		this.code = code;
		this.desc = desc;
	}

	public String getDesc()
	{
		return desc;
	}

	public void setDesc(String desc)
	{
		this.desc = desc;
	}

	public Integer getCode()
	{
		return code;
	}

	public void setCode(Integer code)
	{
		this.code = code;
	}
}
