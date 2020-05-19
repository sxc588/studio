package com.github.cbb.redis;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

public class JResisClasterTest
{

	RedisClient Client = new RedisClient();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception
	{
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception
	{
	}

	@Test
	public void test()
	{
		Client.show();
	}

}
