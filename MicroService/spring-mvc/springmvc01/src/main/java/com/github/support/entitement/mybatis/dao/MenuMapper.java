package com.github.support.entitement.mybatis.dao;

import com.github.support.entitement.mybatis.model.Menu;

public interface MenuMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int insert(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int insertSelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    Menu selectByPrimaryKey(String id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeySelective(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKeyWithBLOBs(Menu record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table t_menu
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(Menu record);
}