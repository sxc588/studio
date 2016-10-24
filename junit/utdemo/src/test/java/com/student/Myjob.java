package com.student;

import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;
import java.util.Date;

/**
 * quartz定时器测试
 * 
 * @author leizhimin 2009-7-23 8:49:01
 */
public class Myjob implements Job
{
	public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException
	{
		System.out.println(new Date() + ": doing something...");
	}
}