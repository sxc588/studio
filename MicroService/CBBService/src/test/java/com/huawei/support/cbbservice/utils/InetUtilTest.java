package com.huawei.support.cbbservice.utils;

import java.net.SocketException;
import java.net.UnknownHostException;

import org.junit.Before;
import org.junit.Test;

public class InetUtilTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testGetLocalIP() throws UnknownHostException {
		String ip = InetUtil.getLocalIP();
		System.out.println(ip);
	}

	@Test
	public void testUploadIPs() throws SocketException {
		String uploadIpList =  InetUtil.uploadIPs();
		
		String ip = InetUtil.getLocalIP2(uploadIpList);
		System.out.println(ip);
	}

//	@Test
//	public void testGetLocalIP2() {
//		fail("Not yet implemented");
//	}
//
//	@Test
//	public void testGetQuotedFilePath() {
//		fail("Not yet implemented");
//	}

}
