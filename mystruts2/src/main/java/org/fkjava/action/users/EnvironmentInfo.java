package org.fkjava.action.users;

public class EnvironmentInfo
{
	
	String name;
	String value;
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getValue()
	{
		return this.value;
	}
	public void setValue(String value)
	{
		this.value = value;
	}
	public EnvironmentInfo(String name, String value)
	{
		super();
		this.name = name;
		this.value = value;
	}
	
	

}
