package com.github.support.utils.net;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 判断网络连接状况.
 * 
 */
public class PingUtils
{

	static private Logger LOG = LoggerFactory.getLogger(PingUtils.class);
	
	public static boolean ping(String host)
	{
		boolean connect = false;
		Runtime runtime = Runtime.getRuntime();
		Process process;
		try
		{
			process = runtime.exec("ping " + host);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
			{
				LOG.info(line);
				if (connect || line.indexOf("TTL") > 0)
				{
					// 网络畅通
					connect = true;
				}
				else
				{
					// 网络不畅通
					connect = false;
				}
			}
			//System.out.println("返回值为:" + sb);
			is.close();
			isr.close();
			br.close();
		} catch (IOException e)
		{
			e.printStackTrace();
		}
		return connect;
	}

//	public static void main(String[] args)
//	{
//		System.out.println(PingUtils.ping("www.baidu.com"));
//
//	}
}