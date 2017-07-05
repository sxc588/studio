package com.github.support.migrate.core.handler;

import java.util.Date;

public interface IMigrateHandler
{
	void migrate(Date startTime, Date endTime, boolean isIncrease);
	
	void delete(Date startTime, Date endTime);
}
