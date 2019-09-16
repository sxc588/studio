package com.github.support.dbaccess.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.ScheduleJob;
import com.github.support.dbaccess.mapper.ScheduleJobMapper;

@Repository
public class ScheduleJobServiceDb {

	@Autowired
	private ScheduleJobMapper mapper;

	public int deleteByPrimaryKey(Long scheduleJobId) {
		return mapper.deleteByPrimaryKey(scheduleJobId);
	}

	public List<ScheduleJob> getList(int offset, int pagesize) {
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", pagesize);
		return mapper.getList(map);
	}

	public int insert(ScheduleJob record) {
		return mapper.insert(record);
	}

	public int insertSelective(ScheduleJob record) {
		return mapper.insertSelective(record);

	}

	public ScheduleJob selectByPrimaryKey(Long scheduleJobId) {
		return mapper.selectByPrimaryKey(scheduleJobId);
	}

	public int updateByPrimaryKey(ScheduleJob record) {
		return mapper.updateByPrimaryKey(record);
	}

	public int updateByPrimaryKeySelective(ScheduleJob record) {
		return mapper.updateByPrimaryKeySelective(record);
	}

}