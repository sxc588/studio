package com.bjsxt.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import org.apache.commons.lang.StringUtils;

/**
 * 
 * @author Administrator
 *
 */
public class SystemUtil
{

	/**
	 * 获取本机的 机器名
	 * 
	 * @return IP
	 */
	public static String getCanonicalHostName()
	{
		try
		{
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getCanonicalHostName();
		} catch (UnknownHostException e)
		{
			e.printStackTrace();

			return StringUtils.EMPTY;
		}

	}
	
	/**
	 * 获取本机的 机器名
	 * 
	 * @return IP
	 */
	public static String getHostName()
	{
		try
		{
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostName();
		} catch (UnknownHostException e)
		{
			e.printStackTrace();

			return StringUtils.EMPTY;
		}
	}

	/**
	 * 获取本机的IP
	 * 
	 * @return IP
	 */
	public static String getLocalIP()
	{
		try
		{
			InetAddress addr = InetAddress.getLocalHost();
			return addr.getHostAddress().toString();
		} catch (UnknownHostException e)
		{
			e.printStackTrace();
			return StringUtils.EMPTY;
		}

	}
}

// 声明式事务