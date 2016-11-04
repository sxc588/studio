package com.github.support.cbbservice.json;

import java.util.List;

public class Student
{
	private String name;
	private int age;
	private List<Teacher> teachers;

	public void setName(String name)
	{
		this.name = name;
	}

	public String getName()
	{
		return name;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public int getAge()
	{
		return age;
	}

	public void setTeachers(List<Teacher> teachers)
	{
		this.teachers = teachers;
	}

	public List<Teacher> getTeachers()
	{
		return teachers;
	}

}
