package com.github.support.quartz.service;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

/**
 * 
 * 解决quartz的job无法注入spring对象
 * 
 * @author Administrator
 *
 */
public final class SpringSchedualeJobBeanFactory extends SpringBeanJobFactory implements ApplicationContextAware
{
	private ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;

	}

	@Override
	protected Object createJobInstance(TriggerFiredBundle bundle) throws Exception
	{
		// 调用父类的方法
		Object jobInstance = super.createJobInstance(bundle);

		// 进行注入
		applicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
		return jobInstance;
	}

}
