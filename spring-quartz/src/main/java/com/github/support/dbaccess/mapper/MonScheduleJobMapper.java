package com.github.support.dbaccess.mapper;

import java.util.List;
import java.util.Map;

import com.github.support.dbaccess.dto.MonScheduleCronExpression;
import com.github.support.dbaccess.dto.MonScheduleJob;

public interface MonScheduleJobMapper {
	int deleteByPrimaryKey(Long scheduleJobId);

	List<MonScheduleJob> getList(Map<String, Object> map);

	List<MonScheduleJob> getScheduleByCorn(Map<String, Object> map);

	Integer getScheduleCountByCorn(String cronExpression);

	/**
	 * 
	 */
	List<MonScheduleCronExpression> getSeudleCorns();

	int insert(MonScheduleJob record);

	int insertSelective(MonScheduleJob record);

	MonScheduleJob selectByPrimaryKey(Long scheduleJobId);

	int updateByPrimaryKey(MonScheduleJob record);

	int updateByPrimaryKeySelective(MonScheduleJob record);
}