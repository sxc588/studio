package com.github.support.cbbservice.utils;

import static com.github.support.cbb.ehcache.utils.PropertiesUtil.readValue;
import static com.github.support.cbb.ehcache.utils.PropertiesUtil.writeProperties;
import org.junit.Test;

public class PropertiesUtilTest
{

	// 属性文件的路径
	static String profilepath= "D:\\Workspaces\\MyEclipsePro2013\\CBBService\\src\\main\\java\\com\\huawei\\support\\cbbservice\\jms\\mail.properties";

	@Test
	public void testGetKeyValue()
	{
		String value = readValue(profilepath, "MAIL_SERVER_PASSWORD");
		System.out.println(value);
		writeProperties("MAIL_SERVER_INCOMING", "327@qq.com");
		writeProperties("MAIL_SERVER_INCOMING33", "327@qq.com33");
		System.out.println("操作完成");
	}



}
