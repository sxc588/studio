package com.github.support.migrate.demo.tasks.ent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.support.migrate.core.handler.IHanderManager;
import com.github.support.migrate.core.handler.IMigrateHandler;

@Service
public class HanderManagerImpl implements IHanderManager
{
	@Autowired
	MigrateImpl handler;
	
	@Override
	public IMigrateHandler getHandler(String taskName)
	{
		return handler;
	}
}
