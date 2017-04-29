package org.fkjava.action;

public class ServiceInfo
{
	public ServiceInfo(String name, String description, String port, String doublePort)
	{
		super();
		this.name = name;
		this.description = description;
		this.port = port;
		this.doublePort = doublePort;
	}
	public String getName()
	{
		return this.name;
	}
	public void setName(String name)
	{
		this.name = name;
	}
	public String getDescription()
	{
		return this.description;
	}
	public void setDescription(String description)
	{
		this.description = description;
	}
	public String getPort()
	{
		return this.port;
	}
	public void setPort(String port)
	{
		this.port = port;
	}
	public String getDoublePort()
	{
		return this.doublePort;
	}
	public void setDoublePort(String doublePort)
	{
		this.doublePort = doublePort;
	}
	String name;
	String description;
	String port;
	String doublePort;
}
