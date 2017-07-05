package com.github.support.db.migrate.mapper;

import com.github.support.db.migrate.model.BusinessErrLog;

public interface BusinessErrLogMapper {
    int deleteByPrimaryKey(String taskId);

    int insert(BusinessErrLog record);

    int insertSelective(BusinessErrLog record);

    BusinessErrLog selectByPrimaryKey(String taskId);

    int updateByPrimaryKeySelective(BusinessErrLog record);

    int updateByPrimaryKey(BusinessErrLog record);
}