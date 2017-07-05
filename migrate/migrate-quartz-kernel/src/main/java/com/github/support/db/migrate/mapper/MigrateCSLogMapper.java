package com.github.support.db.migrate.mapper;

import com.github.support.db.migrate.model.MigrateCSLog;

public interface MigrateCSLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MigrateCSLog record);

    int insertSelective(MigrateCSLog record);

    MigrateCSLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MigrateCSLog record);

    int updateByPrimaryKey(MigrateCSLog record);
}