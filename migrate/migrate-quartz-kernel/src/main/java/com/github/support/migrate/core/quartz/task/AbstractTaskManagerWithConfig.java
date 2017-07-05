package com.github.support.migrate.core.quartz.task;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.scheduling.TaskScheduler;

public abstract class AbstractTaskManagerWithConfig implements ITaskManager
{
	// 注意format的格式要与日期String的格式相匹配
	private static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	protected String groupName;
	
	Map<String, String> tasks = new HashMap<String, String>();

	@Override
	public Date getDBTime()
	{
		return new Date();
	}

	@Override
	public void updateEndTime(String taskName, Date endTime)
	{
		String oldValue = tasks.get(taskName);

		String[] arc = oldValue.split("|");
		if (arc.length >= 6)
		{
			arc[3] = arc[4];
			arc[4] = sdf.format(endTime);
		}

		StringBuilder sBuilder = new StringBuilder(arc[0]);
		for (int i = 0; i < arc.length; i++)
		{
			sBuilder.append("|").append(arc[i]);
		}

		String newValue = sBuilder.toString();

		tasks.put(taskName, newValue);

	}

	public abstract void init();

	@Override
	public Task getTask(String taskName)
	{
		return toTask(taskName, tasks.get(taskName));
	}

	@Override
	public List<Task> getTasks(String groupName)
	{
		List<Task> ts = new ArrayList<Task>();

		for (Map.Entry<String, String> en : this.tasks.entrySet())
		{
			ts.add(toTask(en.getKey(), en.getValue()));
		}
		return ts;
	}

	protected AbstractTaskManagerWithConfig(String groupName)
	{
		this.groupName = groupName;
	}

	protected void initConifg(String key, String value, String desc, String isEdit, String lastUpdateBy) throws ParseException
	{
		Task task = toTask(key, value);
		tasks.put(key, value);
	}

	private static Task toTask(String taskName, String configValue)
	{
		configValue.split("|");

		// class|corn|enable|starTime|endTime|incease|threadCount

		try
		{
			String[] arc = configValue.split("|");
			if (arc.length >= 6)
			{
				Task task = new Task();
				task.setTaskName(taskName);
				task.setJobClsName(arc[0]);
				task.setCorn(arc[1]);

				task.setEnable("1".equals(arc[2]));
				task.setStartTime(sdf.parse(arc[3]));
				task.setEndTime(sdf.parse(arc[4]));
				task.setIncrease("1".equals(arc[5]));

				int threadCount = Integer.parseInt(arc[6]);
				task.setTheadCount(threadCount);

				return task;
			}
		}
		catch (Exception e)
		{
			// TODO: handle exception
		}
		throw new IllegalAccessError("Do not reachable access error");
	}

	public static String toTask(Task task)
	{
		// class|corn|enable|starTime|endTime|incease|threadCount

		StringBuilder builder = new StringBuilder(task.getJobClsName());

		builder.append('|').append(task.getCorn());
		builder.append('|').append(task.getCorn());
		builder.append('|').append(task.getEnable());
		builder.append('|').append(sdf.format(task.getStartTime()));
		builder.append('|').append(sdf.format(task.getEndTime()));
		builder.append('|').append(task.getTheadCount());

		return builder.toString();
	}

}
