package com.github.support.db.migrate.mapper;

import com.github.support.db.migrate.model.MigrateCMLog;

public interface MigrateCMLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MigrateCMLog record);

    int insertSelective(MigrateCMLog record);

    MigrateCMLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MigrateCMLog record);

    int updateByPrimaryKey(MigrateCMLog record);
}