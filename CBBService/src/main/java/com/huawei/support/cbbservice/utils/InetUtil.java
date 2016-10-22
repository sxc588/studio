/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.huawei.support.cbbservice.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetUtil
{
	@Deprecated
	public static String getLocalIP() throws UnknownHostException
	{
		InetAddress address = InetAddress.getLocalHost();
		return address.getHostAddress().toString();
	}

	public static String getLocalIP2() 
	{
		return null;
	}
	
	/**
	 * 对文件路径用双引号括起来
	 * @param filePath 源文件路基
	 * @return String
	 */
	public static String getQuotedFilePath(String filePath)
	{
		char quated='"';
		StringBuilder sb = new StringBuilder(filePath.length() +2);
		sb.append(quated).append(filePath).append(quated);
		return sb.toString();
	}
}
