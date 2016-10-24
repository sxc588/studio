package com.bjsxt.util;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
		Date date=new Date();
		String dateStr = dateFormater.format(date);
		return dateStr;

	}
	
	/**
	 * 判断IP的格式和范围
	 */
	public static boolean isIP(String ip)
	{
		String rexp="([1-9]|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])(\\.(\\d|[1-9]\\d|1\\d{2}|2[0-4]\\d|25[0-5])){3}";
		
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(ip);
		
		return mat.find();
		
	}
	
	/**
	 * 判断Port的格式和范围
	 * @param port
	 * @return
	 */
	public static boolean isPort(String port)
	{
		String rexp="^([1-9]|[1-9]\\d{1,3}|[1-6][0-5][0-5][0-3][0-5])$";
		
		Pattern pat = Pattern.compile(rexp);
		Matcher mat = pat.matcher(port);
		return mat.find();
	}
	
}

// 声明式事务