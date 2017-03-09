package org.fkjava.domain;

public class Book
{
	String id;
	String name;
	String auth;
	float price;

	public Book()
	{
		super();
	}

	public Book(String id, String name, String auth, float price)
	{
		super();
		this.id = id;
		this.name = name;
		this.auth = auth;
		this.price = price;
	}

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

	public String getAuth()
	{
		return auth;
	}

	public void setAuth(String auth)
	{
		this.auth = auth;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
}
