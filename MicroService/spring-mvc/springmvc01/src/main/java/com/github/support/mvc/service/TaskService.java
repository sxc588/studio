package com.github.support.mvc.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.stereotype.Service;
import com.github.support.entitement.mybatis.dao.MigrationTaskMapper;
import com.github.support.entitement.mybatis.model.MigrationTask;

@Service
public class TaskService
{

	private MigrationTaskMapper migrationTaskMapper;

	public List<MigrationTask> getAll()
	{
		 List<MigrationTask> list =new  ArrayList<MigrationTask>();
	for (Integer i=0; i<10; i++)
	{
		MigrationTask task = new MigrationTask();
		task.setTaskId(i.toString());
		task.setTaskName("Name");
		task.setLastExcuteTime(new Date());
		task.setIsEnable(true);
		task.setIsEnableDelete(true);
		task.setLastUpdateTime(new Date());
		task.setLastUpdateBy("lastUpdateBy");
	
		
		list.add(task);
		
	}
		return list;
		
		
		//return migrationTaskMapper.getAll();
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
