package com.glen.beantest;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

//BeanNameAware、ApplicationContextAware和BeanFactoryAware
//这三个接口放在一起写，是因为它们是一组的，作用相似。
//"Aware"的意思是"感知到的"，那么这三个接口的意思也不难理解：
//1、实现BeanNameAware接口的Bean，在Bean加载的过程中可以获取到该Bean的id
//2、实现ApplicationContextAware接口的Bean，在Bean加载的过程中可以获取到Spring的ApplicationContext，这个尤其重要，
//ApplicationContext是Spring应用上下文，从ApplicationContext中可以获取包括任意的Bean在内的大量Spring容器内容和信息
//3、实现BeanFactoryAware接口的Bean，在Bean加载的过程中可以获取到加载该Bean的BeanFactory

//<bean id="AwareBean" class="org.xrq.bean.aware.AwareBean" />

//关于这三个接口以及上面的打印信息，总结几点：
//1、如果你的BeanName、ApplicationContext、BeanFactory有用，那么就自己定义一个变量将它们保存下来，如果没用，那么只需要实现setXXX()方法，用一下Spring注入进来的参数即可
//2、如果Bean同时还实现了InitializingBean，容器会保证BeanName、ApplicationContext和BeanFactory在调用afterPropertiesSet()方法被注入

public class AwareBean implements BeanNameAware, BeanFactoryAware, ApplicationContextAware
{
	private String beanName;

	private ApplicationContext applicationContext;

	private BeanFactory beanFactory;

	@Override
	public void setBeanName(String beanName)
	{
		System.out.println("Enter AwareBean.setBeanName(), beanName = " + beanName + "\n");
		this.beanName = beanName;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		System.out.println("Enter AwareBean.setApplicationContext(), applicationContext = " + applicationContext + "\n");
		this.applicationContext = applicationContext;
	}

	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException
	{
		System.out.println("Enter AwareBean.setBeanFactory(), beanfactory = " + beanFactory + "\n");
		this.beanFactory = beanFactory;
	}
}
