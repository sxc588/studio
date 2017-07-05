package com.github.support.db.migrate.mapper;

import com.github.support.db.migrate.model.TaskDef;

public interface TaskDefMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TaskDef record);

    int insertSelective(TaskDef record);

    TaskDef selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(TaskDef record);

    int updateByPrimaryKey(TaskDef record);
}