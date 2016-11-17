package com.github.support.aop;

import static org.hamcrest.CoreMatchers.nullValue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

//Spring默认不支持@Aspect风格的切面声明，通过如下配置开启@Aspect支持
//<aop:aspectj-autoproxy/> 

@Aspect
public class AspectMapper2
{
	private static Logger LOG = Logger.getLogger(AspectMapper2.class);

	@Pointcut("execution(* com.github.support.aop.service.impl.*.*(..))")
	public void init()
	{
	}

	@Before(value = "init()")
	public void before()
	{
		LOG.info("方法执行前执行.....");
	}

	@AfterReturning(value = "init()")
	public void afterReturning()
	{
		LOG.info("方法执行完执行.....");
	}

	@AfterThrowing(value = "init()")
	public void throwss()
	{
		LOG.info("方法异常时执行.....");
	}

	@After(value = "init()")
	public void after()
	{
		LOG.info("方法最后执行.....");
	}

	@Around(value = "init()")
	public Object around(ProceedingJoinPoint pjp)
	{
		LOG.info("方法环绕start.....");
		Object o = null;
		try
		{
			o = pjp.proceed();
		}
		catch (Throwable e)
		{
			e.printStackTrace();
		}
		LOG.info("方法环绕end.....");
		return o;
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
