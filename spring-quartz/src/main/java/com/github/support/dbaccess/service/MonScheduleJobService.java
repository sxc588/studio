package com.github.support.dbaccess.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.MonScheduleCronExpression;
import com.github.support.dbaccess.dto.MonScheduleJob;
import com.github.support.dbaccess.mapper.MonScheduleJobMapper;

@Repository
public class MonScheduleJobService
{
	
	@Autowired
	private MonScheduleJobMapper mapper;
	

	public int deleteByPrimaryKey(Long scheduleJobId)
	{
		return mapper.deleteByPrimaryKey(scheduleJobId);
	}

	public int insert(MonScheduleJob record)
	{
		return mapper.insert(record);
	}


	public int insertSelective(MonScheduleJob record)
	{
		return mapper.insertSelective(record);
	}

	public MonScheduleJob selectByPrimaryKey(Long scheduleJobId)
	{
		return mapper.selectByPrimaryKey(scheduleJobId);
	}


	public int updateByPrimaryKeySelective(MonScheduleJob record)
	{
		return mapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKey(MonScheduleJob record)
	{
		return mapper.updateByPrimaryKey(record);
	}

	public List<MonScheduleJob> getList(int offset, int pagesize)
	{
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", pagesize);
		return mapper.getList(map);
	}
	
	public List<MonScheduleCronExpression> getSeudleCorns()
	{
		return mapper.getSeudleCorns();
	}

	public List<MonScheduleJob> getScheduleByCorn(String cronExpression, int offset, int pagesize)
	{
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("cronExpression", cronExpression);
		map.put("offset", offset);
		map.put("limit", pagesize);
		return mapper.getScheduleByCorn(map);
	}
	

}