package com.bjsxt.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
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

	private final static SimpleDateFormat dateFormater = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss.SSS");

	/**
	 * 获取当前的时间戳，格式【 yyyy-MM-dd hh:mm:ss.SSS】
	 * 
	 */
	public static String currentTimeStamp()
	{
		Date date = new Date();
		String dateStr = dateFormater.format(date);
		return dateStr;

	}

}

// 声明式事务