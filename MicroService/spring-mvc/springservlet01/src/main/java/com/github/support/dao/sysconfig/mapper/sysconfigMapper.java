package com.github.support.dao.sysconfig.mapper;

import com.github.support.dao.sysconfig.model.sysconfig;

public interface sysconfigMapper {
    int deleteByPrimaryKey(String key);

    int insert(sysconfig record);

    int insertSelective(sysconfig record);

    sysconfig selectByPrimaryKey(String key);

    int updateByPrimaryKeySelective(sysconfig record);

    int updateByPrimaryKey(sysconfig record);
}