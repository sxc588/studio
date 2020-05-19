package com.github.support.utils;

import java.util.List;

import org.junit.Test;

public class HttpClient11Test extends HttpClient11 {

	String loginAction = "https://uniportal.huawei.com/uniportal";

	@Test
	public void test() throws Exception {
		// for (int i= 0; i<10; i++)
		{
			List<String> cookies = HttpClient11.getCookie("s00318828d", "86322232.j", loginAction);
			// System.err.println(cookies);
		}
	}

}
