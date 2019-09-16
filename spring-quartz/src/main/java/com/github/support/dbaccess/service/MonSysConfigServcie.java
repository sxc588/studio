package com.github.support.dbaccess.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.MonSysConfig;
import com.github.support.dbaccess.mapper.MonSysConfigMapper;

@Repository
public class MonSysConfigServcie {

	@Autowired
	private MonSysConfigMapper mapper;

	public int deleteByPrimaryKey(Integer key) {
		return mapper.deleteByPrimaryKey(key);
	}

	public List<MonSysConfig> getList(int offset, int pagesize) {

		Map<String, Object> map = new HashMap<String, Object>();
		map.put("offset", offset);
		map.put("limit", pagesize);
		return mapper.getList(map);
	}

	public int insert(MonSysConfig record) {
		return mapper.insert(record);

	}

	public MonSysConfig selectByPrimaryKey(Integer key) {
		return mapper.selectByPrimaryKey(key);
	}

	public int updateByPrimaryKey(MonSysConfig record) {
		// TODO Auto-generated method stub
		return 0;
	}
}