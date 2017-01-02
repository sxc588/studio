package com.github.support.mvc.service;

import java.util.List;
import com.github.support.entitement.mybatis.dao.MigrationTaskMapper;
import com.github.support.entitement.mybatis.model.MigrationTask;

public class TaskService
{

	private MigrationTaskMapper migrationTaskMapper;

	public List<MigrationTask> getAll()
	{
		return migrationTaskMapper.getAll();
	}

	public MigrationTask get(String id)
	{
		return migrationTaskMapper.selectByPrimaryKey(id);
	}

	public int save(MigrationTask task)
	{
		if (migrationTaskMapper.selectByPrimaryKey(task.getTaskId()) != null)
		{
			return migrationTaskMapper.updateByPrimaryKeySelective(task);
		}
		else
		{
			return migrationTaskMapper.insertSelective(task);
		}
	}

	public int delete(String taskId)
	{
		return migrationTaskMapper.deleteByPrimaryKey(taskId);
		
	}

}
