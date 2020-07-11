package com.github.support.controller.setting.dao;

public interface QueryDao {
	String selectSq2(String sql, Integer page, Integer rows);

	String selectSql(String sql);

	String selectSql1(String sql);
}
