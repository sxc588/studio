package org.fkjava.domain;

import java.util.Date;

public class User
{

	public User()
	{
		super();
	}
	public User(String id, String name, String pass, float weight, Date birthDay)
	{
		super();
		this.id = id;
		this.name = name;
		this.pass = pass;
		this.weight = weight;
		this.birthDay = birthDay;
	}
	@Override
	public int hashCode()
	{
		final int prime = 31;
		int result = 1;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((pass == null) ? 0 : pass.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj)
	{
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		User other = (User) obj;
		if (name == null)
		{
			if (other.name != null) return false;
		}
		else if (!name.equals(other.name)) return false;
		if (pass == null)
		{
			if (other.pass != null) return false;
		}
		else if (!pass.equalsIgnoreCase(other.pass)) return false;
		return true;
	}
	String id;
	String name;
	String pass;
	float weight;
	Date birthDay;

	public String getId()
	{
		return id;
	}
	public void setId(String id)
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
	public String getPass()
	{
		return pass;
	}
	public void setPass(String pass)
	{
		this.pass = pass;
	}
	public float getWeight()
	{
		return weight;
	}
	public void setWeight(float weight)
	{
		this.weight = weight;
	}
	public Date getBirthDay()
	{
		return birthDay;
	}
	public void setBirthDay(Date birthDay)
	{
		this.birthDay = birthDay;
	}

}
