/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.github.support.cbbservice.utils;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.List;
import java.util.Properties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InetUtil
{

	private static Logger logger = LoggerFactory.getLogger(InetUtil.class);

	public static String getLocalIP() throws UnknownHostException
	{
		InetAddress address = InetAddress.getLocalHost();
		return address.getHostAddress().toString();
	}

	/**
	 * 获取当前机器的IP
	 * 
	 * @return
	 * @throws SocketException
	 */
	public static String uploadIPs() throws SocketException
	{
		return "192.168.1.106;";

	}

	/**
	 * 获取当前机器的IP
	 * 
	 * @return
	 * @throws SocketException
	 */
	public static String getLocalIP2(String uploadIps) throws SocketException
	{
		Enumeration<NetworkInterface> allnetInterface = null;

		allnetInterface = NetworkInterface.getNetworkInterfaces();

		if (null == allnetInterface)
		{
			return null;
		}

		// 按分割符号 分成数组
		String[] arrray = uploadIps.split(";|,| ");

		List<String> uploadIpList = Arrays.asList(arrray);

		logger.info("ipList:" + uploadIpList);

		while (allnetInterface.hasMoreElements())
		{
			NetworkInterface inter = allnetInterface.nextElement();
			Enumeration<InetAddress> addresses = inter.getInetAddresses();

			while (addresses.hasMoreElements())
			{
				InetAddress address = addresses.nextElement();

				String ip = address.getHostAddress().replace("/", "");
				logger.info("RawIp address:" + address + "--> Fixed address:" + ip);
				if (uploadIpList.contains(ip))
				{
					return ip;
				}
			}
		}

		return null;
	}

	/**
	 * 对文件路径用双引号括起来
	 * 
	 * @param filePath
	 *            源文件路基
	 * @return String
	 */
	public static String getQuotedFilePath(String filePath)
	{
		char quated = '"';
		StringBuilder sb = new StringBuilder(filePath.length() + 2);
		sb.append(quated).append(filePath).append(quated);
		return sb.toString();
	}

	/**
	 * 获取内存信息
	 * 
	 * @return
	 */
	public static final String getRamInfo()
	{
		Runtime rt = Runtime.getRuntime();
		return "RAM:" + rt.totalMemory() / 1024 / 1024 + "MB total," + rt.freeMemory() / 1024 / 1024 + "MB free.";
	}

	/**
	 * 获取操作系统名称
	 * 
	 * @return
	 */
	public static String getSystemOsName()
	{
		Properties props = System.getProperties();
		String osName = props.getProperty("os.name");
		return osName;
	}

	/**
	 * 获取类Unix系统的IP
	 * 
	 * @return
	 * @throws Exception
	 */
	public static InetAddress getUnixLocalIp() throws Exception
	{
		Enumeration<NetworkInterface> netInterfaces = NetworkInterface.getNetworkInterfaces();
		if (null == netInterfaces)
		{
			throw new Exception("获取类Unix系统的IP失败");
		}
		InetAddress ip = null;
		while (netInterfaces.hasMoreElements())
		{
			NetworkInterface ni = netInterfaces.nextElement();
			if (ni.isUp())
			{
				Enumeration<InetAddress> addressEnumeration = ni.getInetAddresses();
				while (addressEnumeration.hasMoreElements())
				{
					ip = addressEnumeration.nextElement();
					if (ip.isSiteLocalAddress() && !ip.isLoopbackAddress() && ip.getHostAddress().indexOf(":") == -1)
					{
						return ip;
					}
				}
			}
		}
		throw new Exception("获取类Unix系统的IP失败");
	}

	/**
	 * 获取window系统的ip，貌似不会返回null
	 * 
	 * @return
	 * @throws UnknownHostException
	 */
	public static InetAddress getWinLocalIp() throws UnknownHostException
	{
		InetAddress inet = InetAddress.getLocalHost();
		return inet;
	}

	/**
	 * 获取本机ip的InetAddress形式
	 * 
	 * @return
	 * @throws Exception
	 */
	private static InetAddress getSystemLocalIP() throws Exception
	{

		InetAddress inet = null;
		String osName = getSystemOsName();
		if ("Windows".compareToIgnoreCase(osName) < 0)
		{
			inet = getWinLocalIp();
		}
		else
		{
			inet = getUnixLocalIp();
		}
		return inet;
	}

	/**
	 * 返回本机IP的字符串形式
	 * 
	 * @return
	 * @throws Exception
	 */
	public static String getLocalIp() throws Exception
	{
		InetAddress inet;

		inet = getSystemLocalIP();
		if (null != inet)
		{
			String ip = inet.getHostAddress();
			logger.info("获取的本机IP为{}", ip);
			return ip;
		}
		throw new Exception("获取ip失败");
	}

}
