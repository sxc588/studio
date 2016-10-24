package com.huawei.cache;

import static org.junit.Assert.*;

import org.junit.Test;

public class CancheUtilTest
{

	@Test
	public void testPutConfig()
	{
		CancheUtil.putConfig("key", "value1");
	}

	@Test
	public void testGetConfig()
	{
		String actual = CancheUtil.getConfig("key");
	
		assertEquals("value1", actual);
	}

	@Test
	public void testDelConfig()
	{
		fail("Not yet implemented");
	}

}
