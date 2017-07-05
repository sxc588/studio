package com.github.support.migrate.demo.tasks.ent;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Service;
import com.github.support.migrate.core.handler.IHanderManager;
import com.github.support.migrate.core.handler.IMigrateHandler;
import com.github.support.migrate.core.log.ILogService;
import com.github.support.migrate.core.quartz.job.AbstractQuartzJob;
import com.github.support.migrate.core.quartz.task.ITaskManager;
import com.github.support.migrate.demo.core.LogServiceImpl;
import com.github.support.migrate.demo.core.TaskManagerImpl;

@Service
public class QuartzJobExample extends AbstractQuartzJob implements ApplicationContextAware
{
	//private static Logger Logger = LoggerFactory.getLogger(QuartzJobExample.class);

	private static ApplicationContext applicationContext;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException
	{
		QuartzJobExample.applicationContext = applicationContext;
	}

	/**
	 * 迁移任务处理器
	 */
	@Override
	protected IMigrateHandler getMigrateHandler(String taskName)
	{
		IHanderManager manager = applicationContext.getBean(HanderManagerImpl.class);
		return manager.getHandler(taskName);
	}

	/**
	 * 任务管理器
	 */
	@Override
	protected ITaskManager getTaskManager(String taskName)
	{
		return applicationContext.getBean(TaskManagerImpl.class);
	}

	/**
	 * 任务管理日志处理器
	 */
	@Override
	protected ILogService getLogMapper(String taskName)
	{
		return applicationContext.getBean(LogServiceImpl.class);
	}
}
