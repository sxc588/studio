package com.github.support.cxf.demo.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.stereotype.Service;
import com.github.support.cxf.demo.MigrateEntProductWs;
import com.github.support.migrate.core.quartz.QuartzManager;
import com.github.support.migrate.demo.tasks.ent.QuartzJobExample;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

@Service
public class  MigrateEntProductWsImpl implements MigrateEntProductWs,BeanNameAware
{
	private static Logger logger = LoggerFactory.getLogger(MigrateEntProductWsImpl.class);

	@Override
	public User getTask(String username)
	{
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setBeanName(String name)
	{
		System.err.println("DDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD" + name);
		
		try
		{
		
		String job_name = "动态任务调度";
		System.out.println("【系统启动】开始(每1秒输出一次)...");
		QuartzManager.addJob(job_name, QuartzJobExample.class, "0/1 * * * * ?");

		Thread.sleep(3000);
		System.out.println("【修改时间】开始(每2秒输出一次)...");
		QuartzManager.modifyJobTime(job_name, "10/2 * * * * ?");
		Thread.sleep(4000);
		System.out.println("【移除定时】开始...");
		QuartzManager.removeJob(job_name);
		System.out.println("【移除定时】成功");

		System.out.println("【再次添加定时任务】开始(每10秒输出一次)...");
		QuartzManager.addJob(job_name, QuartzJobExample.class, "*/10 * * * * ?");
		Thread.sleep(30000);
		System.out.println("【移除定时】开始...");

		QuartzManager.removeJob(job_name);
		System.out.println("【移除定时】成功");
		}catch (Throwable e)
		{
			
		}
	}
}