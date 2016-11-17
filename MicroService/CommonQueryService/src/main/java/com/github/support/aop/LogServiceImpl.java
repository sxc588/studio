package com.github.support.aop;

import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;


public class LogServiceImpl implements ILogService
{
	private static Logger LOG = Logger.getLogger(LogServiceImpl.class);

	@Override
	public void log()
	{
		LOG.info("log===");
	}

	// 有参无返回值的方法
	@Override
	public void logArg(JoinPoint point)
	{
		// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		Object[] args = point.getArgs();

		String argsString = toStirng(args);
		LOG.info("logArg===》目标参数列表:" + argsString);
	}
	
	// 有参并有返回值的方法
	@Override
	public void logArgAndReturn(JoinPoint point, Object returnObj)
	{
		// 此方法返回的是一个数组，数组中包括request以及ActionCofig等类对象
		Object[] args = point.getArgs();
		String argsString = toStirng(args);
		LOG.info("logArgAndReturn===》目标参数列表:" + argsString);
		LOG.info("logArgAndReturn===》执行结果是" + returnObj);
	}
	
	private String toStirng(Object[] args)
	{
		if (args != null)
		{
			StringBuilder sb = new StringBuilder();
			for (Object obj : args)
			{
				sb.append(obj + ",");
			}
			String argsString = sb.toString();
			return argsString;
		}
		return StringUtils.EMPTY;
	}

}
