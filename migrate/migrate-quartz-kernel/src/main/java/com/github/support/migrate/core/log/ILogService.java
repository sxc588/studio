package com.github.support.migrate.core.log;

import java.util.Date;

public interface ILogService
{
	public void log(String who, String when, String string2);

	public void log(String string, String name, String string2, Date startTime, Date endTime, String string3);

}
