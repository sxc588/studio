package com.github.support.utils;

import java.io.FileNotFoundException;
import java.net.BindException;
import java.security.acl.NotOwnerException;
import java.sql.SQLException;
import java.util.ConcurrentModificationException;
import java.util.MissingResourceException;
import java.util.jar.JarException;
import org.apache.commons.lang.StringEscapeUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;

public final class CodeCCUtil
{
	
	public static void errLog(Logger log, String msg, Throwable cause)
	{		
		if (StringUtils.isBlank(msg) || null == cause)
		{
			return ;
		}
		
		Throwable stacktrace = cause.getCause();
		if (stacktrace instanceof FileNotFoundException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof JarException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof MissingResourceException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		
		if (stacktrace instanceof NotOwnerException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof ConcurrentModificationException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		
		if (stacktrace instanceof BindException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof OutOfMemoryError)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof StackOverflowError)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		if (stacktrace instanceof SQLException)
		{
			String newMsg = clearLogForging(msg);
			log.error(newMsg);
			return ;
		}
		
		try
		{
			throw new Exception(msg,cause);
		}
		catch (Exception e)
		{
			log.error(msg,cause.getCause());
		}
	}

	private static String clearLogForging(String msg)
	{
	    if (StringUtils.isBlank(msg))
	    {
	    	return StringUtils.EMPTY;
	    }
	    String clean = msg.replace('\n', '_').replace('\r', '_');
	    
	    
		return clean;
	}
	
	public static String clearTructViolation(String msg)
	{
	    if (StringUtils.isBlank(msg))
	    {
	    	return StringUtils.EMPTY;
	    }
	    
	    //String clean = StringEscapeUtils.unescapeHtml4(msg);
	    String clean = StringEscapeUtils.unescapeHtml(msg);

		return clean;
	}

}
