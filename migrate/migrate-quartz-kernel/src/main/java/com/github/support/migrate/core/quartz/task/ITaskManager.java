package com.github.support.migrate.core.quartz.task;

import java.util.Date;
import java.util.List;

public interface ITaskManager
{
	List<Task> getTasks(String groupName);
	
	Task getTask(String taskName);

	Date getDBTime();

	void updateEndTime(String name, Date endTime);
}
