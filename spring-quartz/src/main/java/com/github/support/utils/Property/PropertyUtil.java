package com.github.support.utils.Property;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import org.apache.commons.io.IOUtils;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Desc:properties文件获取工具类 Created by hafiz.zhang on 2016/9/15.
 */
public class PropertyUtil
{
	private static final Logger logger = LoggerFactory.getLogger(PropertyUtil.class);
	private static Properties props;
	static
	{
		loadProps();
	}

	synchronized static private void loadProps()
	{
		logger.info("开始加载properties文件内容.......");
		props = new Properties();
		InputStream in = null;
		try
		{
			// 第一种，通过类加载器进行获取properties文件流
			in = PropertyUtil.class.getClassLoader().getResourceAsStream("quartz.properties");
			// -第二种，通过类进行获取properties文件流
			// in = PropertyUtil.class.getResourceAsStream("/jdbc.properties");
			props.load(in);
		}
		catch (FileNotFoundException e)
		{
			logger.error("jdbc.properties文件未找到");
		}
		catch (IOException e)
		{
			logger.error("出现IOException");
		}
		finally
		{
			IOUtils.closeQuietly(in);
		}
		logger.info("加载properties文件内容完成...........");
		logger.info("properties文件内容：" + props);
	}

	public static String getProperty(String key)
	{
		if (null == props)
		{
			loadProps();
		}
		return props.getProperty(key);
	}

	public static String getProperty(String key, String defaultValue)
	{
		if (null == props)
		{
			loadProps();
		}
		return props.getProperty(key, defaultValue);
	}
	
	
	public static int getInteger(String key, int defaultValue)
	{
		if (null == props)
		{
			loadProps();
		}
		
		String value = props.getProperty(key);
		
		try
		{
			int intVal = Integer.parseInt(value);
		    return intVal;
		}
		catch (NumberFormatException e) {
			// TODO: handle exception
		}
	    return defaultValue;
	}
	
	@Test
	public void aaa()
	{
		for (int i=0; i<90000; i++)
		{
			int value = getInteger("org.quartz.threadPool.threadCount", 123);
		//System.out.println(value);
		
		}
	}
}