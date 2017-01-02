package com.github.support.entitement.mybatis.dao;

import java.util.List;
import com.github.support.entitement.mybatis.model.MigrationTask;

public interface MigrationTaskMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    int insert(MigrationTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    int insertSelective(MigrationTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    MigrationTask selectByPrimaryKey(String taskId);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(MigrationTask record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_migration_task
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(MigrationTask record);

	List<MigrationTask> getAll();
}