package com.github.support.aop;

import static org.hamcrest.CoreMatchers.nullValue;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

//Spring默认不支持@Aspect风格的切面声明，通过如下配置开启@Aspect支持
//<aop:aspectj-autoproxy/> 

@Aspect
public class AspectMapper
{
	private static Logger LOG = Logger.getLogger(AspectMapper.class);

	@Before("execution(* com.github.support.aop.service.impl.*.*(..))")
	public void before(){
		System.out.println("方法执行前执行.....");
	}
	
	//后置返回通知
	@AfterReturning("execution(* com.github.support.aop.service.impl.*.*(..))")
	public void afterReturning(){
		System.out.println("方法执行完执行....."); 
	}
	
	//后置异常通知：
	@AfterThrowing("execution(* com.github.support.aop.service.impl.*.*(..))") 
	public void throwss(){ 
	    System.out.println("方法异常时执行....."); 
	}
	
	@Around("execution(* com.github.support.aop.service.impl.*.*(..))") 
	public Object around(ProceedingJoinPoint pjp){ 
	    System.out.println("方法环绕start....."); 
	    try { 
	      pjp.proceed(); 
	    } catch (Throwable e) { 
	      e.printStackTrace(); 
	    } 
	    System.out.println("方法环绕end....."); 
	    
	    return nullValue();
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
