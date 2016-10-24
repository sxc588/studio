package com.huawei.support.commquery.model;

import org.apache.commons.lang3.builder.ReflectionToStringBuilder;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonRawValue;
import com.fasterxml.jackson.annotation.JsonRootName;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
@JsonRootName(value = "rootNode")
public class JsonCaseB
{

	@JsonRawValue
	private String address = "$#";

	private int age;

	@JsonIgnore
	private String sex;

	public String getAddress()
	{
		return address;
	}

	public void setAddress(String address)
	{
		this.address = address;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public String toString()
	{
		return ReflectionToStringBuilder.toString(this);
	}
}
