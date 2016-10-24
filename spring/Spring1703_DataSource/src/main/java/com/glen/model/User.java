package com.glen.model;

import java.io.Serializable;
import java.util.Date;
import javax.xml.bind.annotation.XmlRootElement;
import com.sun.xml.internal.txw2.annotation.XmlElement;

@XmlRootElement(name="Account")  
public class User implements Serializable
{

	private static final long serialVersionUID = -7970848646314840509L;
	
	private int id;
	private String name;
	private double  age;
	/**
	 * @return the id
	 */
	public int getId()
	{
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id)
	{
		this.id = id;
	}
	/**
	 * @return the name
	 */
	public String getName()
	{
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name)
	{
		this.name = name;
	}
	/**
	 * @return the age
	 */
	public double getAge()
	{
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(double age)
	{
		this.age = age;
	}
	

}