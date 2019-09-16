package com.github.support.dbaccess.mapper;

import java.util.List;
import java.util.Map;

import com.github.support.dbaccess.dto.ScheduleJob;

public interface ScheduleJobMapper {
	int deleteByPrimaryKey(Long scheduleJobId);

	List<ScheduleJob> getList(Map<String, Object> map);

	int insert(ScheduleJob record);

	int insertSelective(ScheduleJob record);

	ScheduleJob selectByPrimaryKey(Long scheduleJobId);

	int updateByPrimaryKey(ScheduleJob record);

	int updateByPrimaryKeySelective(ScheduleJob record);
}