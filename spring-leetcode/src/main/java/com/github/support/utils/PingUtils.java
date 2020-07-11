package com.github.support.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.http.HttpStatus;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 判断网络连接状况.
 * 
 */
public class PingUtils
{
	static private Logger LOG = LoggerFactory.getLogger(PingUtils.class);

	public static PtResoult ping(String host)
	{
		PtResoult result = null;
		boolean connect = false;
		Runtime runtime = Runtime.getRuntime();
		Process process;
		long begin = System.currentTimeMillis();
		try
		{

			process = runtime.exec("ping " + host);
			InputStream is = process.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader br = new BufferedReader(isr);
			String line = null;
			while ((line = br.readLine()) != null)
			{
				LOG.error(line);
				if (connect || line.indexOf("TTL") > 0)
				{
					// 网络畅通
					connect = true;
					// result = new PtResoult(200, "网络畅通",
					// System.currentTimeMillis() - begin);
					result = new PtResoult(HttpStatus.SC_OK, "网络畅通", System.currentTimeMillis() - begin);
					break;
				} else
				{
					// 网络不畅通
					connect = true;
					result = new PtResoult(HttpStatus.SC_NOT_FOUND, "网络不畅通", System.currentTimeMillis() - begin);
				}
			}

			// System.out.println("返回值为:" + sb);
			is.close();
			isr.close();
			br.close();

		} catch (IOException e)
		{
			result = new PtResoult(HttpStatus.SC_INTERNAL_SERVER_ERROR, "IOException-" + e.getMessage(),
					System.currentTimeMillis() - begin);
			e.printStackTrace();
		}
		return result;
	}

	// public static void main(String[] args)
	// {
	// System.out.println(PingUtils.ping("www.baidu.com"));
	//
	// }
}