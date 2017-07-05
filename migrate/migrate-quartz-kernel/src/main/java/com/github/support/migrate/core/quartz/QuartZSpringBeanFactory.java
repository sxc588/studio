package com.github.support.migrate.core.quartz;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class QuartZSpringBeanFactory extends SpringBeanJobFactory implements ApplicationContextAware
{

	private ApplicationContext applicationContext;

	/**
	 * @这里覆盖supper 的createJobInstance方法
	 * @对其创建的类再进行autowireBean 组装
	 */
	@Override
	protected Object createJobInstance(TriggerFiredBundle arg0) throws Exception
	{
		Object jobInstance = super.createJobInstance(arg0);
		applicationContext.getAutowireCapableBeanFactory().autowireBean(jobInstance);
		return jobInstance;
	}

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		this.applicationContext = applicationContext;
		
	}
}
