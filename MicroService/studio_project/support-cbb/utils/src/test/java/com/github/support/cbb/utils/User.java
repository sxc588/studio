package com.github.support.cbb.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;


/**
 * 
 * @version 1.0
 * @author rjgcx
 * @time 2012-3-24 21:38
 */
public class User
{

	@Override
	public String toString()
	{
		return "User [age=" + this.age + ", name=" + this.name + "]";
	}

	int age;
	int name;

	public int getName()
	{
		return name;
	}

	public void setName(int name)
	{
		this.name = name;
	}

	public static void main(String[] args) throws IOException
	{
		String s = "{\"name\":123}";
		ObjectMapper mapper = new ObjectMapper();
		// unmarshalling (reading JSON)
		User a = mapper.readValue(s, User.class);
		
		List<User> kList= new ArrayList<User>();
		kList.add(a);
		kList.add(a);
		
		String tString = mapper.writeValueAsString(kList);

	}
}