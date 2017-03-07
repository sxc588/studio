package com.github.support.cbb.utils;

import static org.junit.Assert.assertEquals;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class JSONUtilTest
{

	@Test
	public void test() throws IOException
	{
		User us = new User();
		us.setName(123);
		
		List<User> kList= new ArrayList<User>();
		kList.add(us);
		kList.add(us);
		
		String json = JSONUtil.toJson(kList);
		
		
		 System.err.println(json);
		 
		 List<User> kList2= JSONUtil.toList(json, User.class);
		 
		 assertEquals(kList2.size(), kList.size());
		 System.err.println(kList2);
	}

}
