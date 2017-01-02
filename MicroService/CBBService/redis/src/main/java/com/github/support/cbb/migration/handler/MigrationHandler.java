package com.github.support.cbb.migration.handler;

import java.util.Date;
import org.springframework.beans.factory.annotation.Autowired;

public class MigrationHandler
{

	@Autowired
	private MigrationSupDispatch supDispatch;

	@Autowired
	private MigrationEntDispatch entDispatch;

	public int migrationAll(String taskId)
	{
		IMigrationHandler hanlder = supDispatch.getHandler(taskId);
		if (hanlder != null)
		{
			return hanlder.migrationAll();
		}

		hanlder = entDispatch.getHandler(taskId);

		if (hanlder != null)
		{
			return hanlder.migrationAll();
		}

		return 0;
	}

	public int migrationInc(Date beginTime, Date endTime, String taskId)
	{
		IMigrationHandler hanlder = supDispatch.getHandler(taskId);
		if (hanlder != null)
		{
			return hanlder.migrationInc(beginTime, endTime);
		}

		hanlder = entDispatch.getHandler(taskId);

		if (hanlder != null)
		{
			return hanlder.migrationInc(beginTime, endTime);
		}

		return 0;
	}

	public int migrationDel(String taskId)
	{
		IMigrationHandler hanlder = supDispatch.getHandler(taskId);
		if (hanlder != null)
		{
			return hanlder.migrationDel();
		}

		hanlder = entDispatch.getHandler(taskId);
		if (hanlder != null)
		{
			return hanlder.migrationDel();
		}
		return 0;
	}
}
