package com.github.support.migrate.core.quartz.task;

import java.io.Serializable;
import java.util.Date;

public class Task implements Serializable
{
	
	/**
	 * 添加作者：Administrator 
	 * 添加时间：2017年6月28日 下午11:32:49
	 */
	private static final long serialVersionUID = 1L;

	/** 
	 * 执行任务 Job的名称
	 */
	String  taskName;
	
	
	
	/** 
	 * 执行任务 Job的名称
	 */
	String  jobClsName;
	
	/**
	 * 迁移的开始时间
	 */
	Date startTime;
	
	/**
	 * 迁移的结束时间
	 */
	Date endTime;
	
	/**
	 * 是否启用
	 */
	Boolean enable;
	
	/**
	 * 是否为增量迁移
	 */
	Boolean increase;
	
	
	/**
	 * 执行的时间表达式
	 */
	String corn;
	
	/**
	 * ThradCount
	 */
	int TheadCount;

	public String getJobClsName()
	{
		return this.jobClsName;
	}

	public void setJobClsName(String jobClsName)
	{
		this.jobClsName = jobClsName;
	}

	public Date getStartTime()
	{
		return this.startTime;
	}

	public void setStartTime(Date startTime)
	{
		this.startTime = startTime;
	}

	public Date getEndTime()
	{
		return this.endTime;
	}

	public void setEndTime(Date endTime)
	{
		this.endTime = endTime;
	}

	public Boolean getEnable()
	{
		return this.enable;
	}

	public void setEnable(Boolean enable)
	{
		this.enable = enable;
	}

	public Boolean getIncrease()
	{
		return this.increase;
	}

	public void setIncrease(Boolean increase)
	{
		this.increase = increase;
	}

	public String getCorn()
	{
		return this.corn;
	}

	public void setCorn(String corn)
	{
		this.corn = corn;
	}

	public int getTheadCount()
	{
		return this.TheadCount;
	}

	public void setTheadCount(int theadCount)
	{
		this.TheadCount = theadCount;
	}

	public static long getSerialversionuid()
	{
		return serialVersionUID;
	}

	public String getTaskName()
	{
		return this.taskName;
	}

	public void setTaskName(String taskName)
	{
		this.taskName = taskName;
	}
	
	
}
