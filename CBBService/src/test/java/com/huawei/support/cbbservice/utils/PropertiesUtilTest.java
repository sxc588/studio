package com.huawei.support.cbbservice.utils;

import static com.huawei.support.cbbservice.utils.PropertiesUtil.readValue;
import static com.huawei.support.cbbservice.utils.PropertiesUtil.writeProperties;
import org.junit.Test;

public class PropertiesUtilTest
{

	// 属性文件的路径
	static String profilepath= "D:\\Workspaces\\MyEclipsePro2013\\CBBService\\src\\main\\java\\com\\huawei\\support\\cbbservice\\jms\\mail.properties";

	@Test
	public void testGetKeyValue()
	{
		String value = readValue(profilepath, "MAIL_SERVER_PASSWORD");
		writeProperties("MAIL_SERVER_INCOMING", "327@qq.com");
		writeProperties("MAIL_SERVER_INCOMING33", "327@qq.com33");
		System.out.println("操作完成");
	}



}
