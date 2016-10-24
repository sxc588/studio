package com.huawei.support.mybatis3.model;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@SuppressWarnings("restriction")
@XmlRootElement // 必须要标明这个元素
@XmlAccessorType(XmlAccessType.FIELD)
public class Student implements Serializable
{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	int age;
	
	
	public Student()
	{
		super();
	}


	public Student(String name, int age)
	{
		super();
		this.name = name;
		this.age = age;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
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

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

}
