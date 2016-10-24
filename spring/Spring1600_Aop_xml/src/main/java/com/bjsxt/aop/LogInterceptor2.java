package com.bjsxt.aop;


import java.lang.reflect.Method;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;


/**
 * 实现动态代理：
 *  --方法1：jdk proxy （必须实现了某个个接口）
 *  --方法2：实现InvocationHandler
 * http://wwyu8901.iteye.com/blog/846919
 *
 *aspect: 专门用于动态代理的框架，spring 使用了它
 * -joinpoint
 * -pointcout
 * -Apspect 切面
 * -advice
 * -target
 * -weave  织入
 */
@Aspect
//@Component
public class LogInterceptor2
{
	long begin =0;
	@Before("execution(* com.bjsxt.service.UserService.*(..))")
	public void beforMethod(){
		begin = System.currentTimeMillis();
		System.out.println("LogInterceptor2.beforMethod->start.");
	}
	
	@After("execution(public int com.bjsxt..*.save(..))")
	public void endMethod(){
		long end = System.currentTimeMillis();
		System.out.println("LogInterceptor2.endMethod->end." + (end - begin) + "ms");
	}
	
	@AfterReturning("execution(public int com.bjsxt..*.save(..))")
	public void AfterReturning(){
		long end = System.currentTimeMillis();
		System.out.println("LogInterceptor2.AfterReturning->end." + (end - begin) + "ms");
	}

	

}
