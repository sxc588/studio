package com.github.support.aop;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import com.github.support.aop.service.ILoginService;

public class SpringAOPTest
{
	public static void testSpringAOPf()
	{
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-aop.xml");
		ILoginService loginService = (ILoginService) ctx.getBean("loginService");
		loginService.login("zhangsan", "12344");
	}
	public static void main(String[] args)
	{
		testSpringAOPf();
	}
}
