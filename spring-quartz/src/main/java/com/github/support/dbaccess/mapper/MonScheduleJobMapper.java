package com.github.support.dbaccess.mapper;

import java.util.List;
import java.util.Map;

import com.github.support.dbaccess.dto.MonScheduleJob;

public interface MonScheduleJobMapper
{
	int deleteByPrimaryKey(Long scheduleJobId);

	int insert(MonScheduleJob record);

	int insertSelective(MonScheduleJob record);

	MonScheduleJob selectByPrimaryKey(Long scheduleJobId);

	int updateByPrimaryKeySelective(MonScheduleJob record);

	int updateByPrimaryKey(MonScheduleJob record);
	
	List<MonScheduleJob> getList(Map<String, Object> map);
}