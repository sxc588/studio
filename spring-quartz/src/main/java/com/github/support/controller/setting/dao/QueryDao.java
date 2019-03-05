package com.github.support.controller.setting.dao;

public interface QueryDao
{
	String selectSql(String sql);
	String selectSql1(String sql);
	String selectSq2(String sql, Integer page, Integer rows);
}
