package com.github.support.migrate.demo.core;

import java.util.Date;
import org.springframework.stereotype.Repository;
import com.github.support.migrate.core.log.ILogService;

@Repository
public class LogServiceImpl implements ILogService
{
	public void log(String who, String when, String string2)
	{
		StringBuilder sb = new StringBuilder();
		sb.append(who);
		sb.append(when);
		sb.append(string2);
	}

	public void log(String string, String name, String string2, Date startTime, Date endTime, String string3)
	{
		// TODO Auto-generated method stub
		
	}
}
