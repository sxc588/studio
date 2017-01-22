package com.github.support.entitement.mybatis.dao;

import com.github.support.entitement.mybatis.model.RoleResource;

public interface RoleResourceMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int insert(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int insertSelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    RoleResource selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(RoleResource record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_roleresource
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(RoleResource record);
}