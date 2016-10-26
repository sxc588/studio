package com.huawei.support.cbbservice.utils;

import static com.huawei.support.cbbservice.utils.FileReplaceUtil.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.junit.Test;


public class FileReplaceUtilTest
{
	@Test
	public void genMate() throws IOException
	{
		String src = "test.properties";
		String dst = "meta.properties";
		String profilepath= "D:\\Workspaces\\MyEclipsePro2013\\CBBService\\src\\main\\java\\com\\huawei\\support\\cbbservice\\jms\\";
		URL url= this.getClass().getResource("/");
		
		System.err.println(url.getPath());

		Map<String, String> abcd = new HashMap<String, String>();
		abcd.put("${SERVER1}", "value1");
		abcd.put("${SERVER2}", "value2");
		abcd.put("${SERVER3}", "value3");
		abcd.put("${SERVER4}", "value4");
		RelplaseMutl(profilepath+src, profilepath+dst, abcd);
	}

}
