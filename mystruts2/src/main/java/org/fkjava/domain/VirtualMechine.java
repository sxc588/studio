package org.fkjava.domain;

public class VirtualMechine
{
	
	// 服务名称
	String name;
	
	// 服务名称
	String stage;
	
	/**
	 * port
	 */
	String port;
	
	
	/**
	 * dubbo - port
	 */
	String dubboPort;
	
	/**
	 * url
	 */
	String url;

	public VirtualMechine()
	{
		super();
		// TODO Auto-generated constructor stub
	}

	public String getName()
	{
		return name;
	}

	public VirtualMechine(String name, String stage, String port, String dubboPort, String url)
{
	super();
	this.name = name;
	this.stage = stage;
	this.port = port;
	this.dubboPort = dubboPort;
	this.url = url;
}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getStage()
	{
		return stage;
	}

	public void setStage(String stage)
	{
		this.stage = stage;
	}

	public String getPort()
	{
		return port;
	}

	public void setPort(String port)
	{
		this.port = port;
	}

	public String getDubboPort()
	{
		return dubboPort;
	}

	public void setDubboPort(String dubboPort)
	{
		this.dubboPort = dubboPort;
	}

	public String getUrl()
	{
		return url;
	}

	public void setUrl(String url)
	{
		this.url = url;
	}

}
