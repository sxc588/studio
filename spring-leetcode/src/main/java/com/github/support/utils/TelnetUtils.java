package com.github.support.utils;

import java.io.IOException;

import org.apache.commons.net.telnet.TelnetClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;

/**
 * 编写JAVA代码在生产环境启用临时端口进行telnet网络测试
 * Telnet协议是TCP/IP协议族中的一员，是Internet远程登陆服务的标准协议和主要方式。它为用户提供了在本地计算机上完成远程主机工作的能力。
 * TelnetClient是commons-net-3.3.jar下的一个类，用于实现telnet连接。
 * 
 * @author Administrator
 *
 */
public class TelnetUtils
{

	static private Logger LOG = LoggerFactory.getLogger(TelnetUtils.class);

	/**
	 * 关闭Telnet连接
	 */
	private static void disconnect(TelnetClient telnetClient)
	{
		try
		{
			Thread.sleep(10);
			if (telnetClient != null)
				telnetClient.disconnect();
		} catch (InterruptedException e1)
		{
			e1.printStackTrace();
		} catch (IOException e2)
		{
			e2.printStackTrace();
		}
	}

	/**
	 * @param ip
	 *            : telnet的IP地址
	 * @param port
	 *            : 端口号，默认11211
	 * @return
	 */
	public static PtResoult telnet(String ip, Integer port)
	{

		PtResoult result = null;

		TelnetClient telnetClient = new TelnetClient();
		try
		{

			long begin = System.currentTimeMillis();
			telnetClient.connect(ip, port);
			// in = telnetClient.getInputStream();
			// out = new PrintStream(telnetClient.getOutputStream());
			long end = System.currentTimeMillis();

			LOG.info("[{}:{}]--telnet Ok! -{}ms; {};{}", ip, port, (end - begin), telnetClient.getRemoteAddress(),
					telnetClient.getLocalAddress());

			return result = new PtResoult(HttpStatus.OK.value(), "telnet Ok!", (end - begin));

		} catch (Exception e)
		{
			LOG.error("[{}:{}]--telnet fail!; {};{}", ip, port, telnetClient.getRemoteAddress(),
					telnetClient.getLocalAddress());
			return result = new PtResoult(HttpStatus.NOT_FOUND.value(), "telnet fail!", -1);

		} finally
		{

			disconnect(telnetClient);
		}
	}

	// public static void main(String[] args) throws InterruptedException
	// {
	// TelnetUtils telnetUtils = new TelnetUtils();
	// while (true)
	// {
	// Thread.sleep(100);
	// telnetUtils.telnet("support.huawei.com", 80);
	// telnetUtils.telnet("www.sohu.com", 80);
	//
	// }
	//
	// // telnetUtils.telnet("192.168.101.152", 11211);
	// // telnetUtils.telnet("192.168.101.193", 11211);
	// // telnetUtils.telnet("192.168.101.193", 12000);
	// }
}