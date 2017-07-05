package com.github.cbb.security;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;

public abstract class CodexCCUtils
{
	
	@Deprecated
	public static void error(Logger logger,String msg ,Throwable e)
	{
		Throwable stackTraceInfo = e.getCause();
//		if (stackTraceInfo instanceof NullPointerException)
//		{
//			//TODO something
//		}
//		
		logger.error(cleanLogForging(msg), stackTraceInfo);
	}
	
	public static void errorLog(Logger logger,String msg ,Throwable e)
	{
		Throwable stackTraceInfo = e.getCause();
//		if (stackTraceInfo instanceof NullPointerException)
//		{
//			//TODO something
//		}
//		
		logger.error(cleanLogForging(msg), stackTraceInfo);
	}
	
	
	public static void report(Logger logger,String msg ,Throwable e)
	{
		Throwable stackTraceInfo = e.getCause();
//		if (stackTraceInfo instanceof NullPointerException)
//		{
//			//TODO something
//		}
//		
		logger.error(cleanLogForging(msg), stackTraceInfo);
	}
	
	private static String  cleanLogForging(String message)
	{
		if (StringUtils.isBlank(message))
		{
			return org.apache.commons.lang3.StringUtils.EMPTY;
		}
		return message.replace('\n', '_').replace('\r', '_');
	}
	
	
}
