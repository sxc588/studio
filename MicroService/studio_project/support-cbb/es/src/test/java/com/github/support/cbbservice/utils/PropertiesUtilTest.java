package com.github.support.cbbservice.utils;

import static com.github.support.cbb.ehcache.utils.PropertiesUtil.readValue;
import static com.github.support.cbb.ehcache.utils.PropertiesUtil.writeProperties;
import org.junit.Test;
import com.github.support.cbb.ehcache.utils.PropertiesUtil;

public class PropertiesUtilTest
{

	@Test
	public void testGetKeyValue()
	{
	//	String value = readValue(PropertiesUtil.profilepath, "MAIL_SERVER_PASSWORD");
	//	System.out.println(value);
		writeProperties("MAIL_SERVER_INCOMING", "327@qq.com");
		writeProperties("MAIL_SERVER_INCOMING33", "327@qq.com33");
		System.out.println("操作完成");
	}
}
