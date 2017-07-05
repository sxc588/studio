package com.github.support.migrate.demo.core;

import org.springframework.stereotype.Repository;
import com.github.support.migrate.core.quartz.task.AbstractTaskManagerWithConfig;

@Repository
public class TaskManagerImpl extends AbstractTaskManagerWithConfig
{
	TaskManagerImpl()
	{
		super("product.init.abcd");
	}

	@Override
	public void init()
	{
		String parentKey = super.groupName;

		try
		{
			initConifg(parentKey, "cfgROOT", "DDDDDDDDDDDDDD", "dddddd", "0");
			initConifg(parentKey + ".product.init.abcd02", parentKey, "DDDDDDDDDDDDDD", "dddddd", "0");
			initConifg(parentKey + ".product.init.abcd03", parentKey, "DDDDDDDDDDDDDD", "dddddd", "0");
			initConifg(parentKey + ".product.init.abcd04", parentKey, "DDDDDDDDDDDDDD", "dddddd", "0");
			initConifg(parentKey + ".product.init.abcd05", parentKey, "DDDDDDDDDDDDDD", "dddddd", "0");
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
	}
}
