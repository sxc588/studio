package com.github.support.dbaccess.mapper;

import java.util.List;
import java.util.Map;

import com.github.support.dbaccess.dto.MonSysConfig;

public interface MonSysConfigMapper
{
    int deleteByPrimaryKey(Integer key);

    int insert(MonSysConfig record);

    MonSysConfig selectByPrimaryKey(Integer key);

    int updateByPrimaryKey(MonSysConfig record);

	List<MonSysConfig> getList(Map<String, Object> map);
}