package com.usermanagersystem.entity;

public class User
{
	private int id;// 用户id
	private String username;// 用户账号
	private String password;// 用户密码
	private String name;// 真实姓名
	private String nic;// 用户昵称
	private String sex;// 性别
	private int age;// 年龄
	private String email;// 电子邮件
	private String phone;// 电话
	private String selfshow;// 个人说明
	private int roleId;// 角色id

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getUsername()
	{
		return username;
	}

	public void setUsername(String username)
	{
		this.username = username;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getNic()
	{
		return nic;
	}

	public void setNic(String nic)
	{
		this.nic = nic;
	}

	public String getSex()
	{
		return sex;
	}

	public void setSex(String sex)
	{
		this.sex = sex;
	}

	public int getAge()
	{
		return age;
	}

	public void setAge(int age)
	{
		this.age = age;
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}

	public String getPhone()
	{
		return phone;
	}

	public void setPhone(String phone)
	{
		this.phone = phone;
	}

	public String getSelfshow()
	{
		return selfshow;
	}

	public void setSelfshow(String selfshow)
	{
		this.selfshow = selfshow;
	}

	public int getRoleId()
	{
		return roleId;
	}

	public void setRoleId(int roleId)
	{
		this.roleId = roleId;
	}

}
