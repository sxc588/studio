package com.bjsxt.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class SystemUtilTest
{

	@Test
	public void test()
	{
		System.out.println(SystemUtil.getCanonicalHostName());
		System.out.println(SystemUtil.getHostName());
		System.out.println(SystemUtil.getLocalIP());
	}

}
