package com.wangwang.db;

import java.sql.ResultSet;
import java.sql.SQLException;

public interface EntityMapping {
	/**
	 * ��rs��ǰ������ת��Ϊһ��ʵ�����
	 * @param rs
	 * @return ����ʵ����
	 * @throws SQLException
	 */
	public Object mapping(ResultSet rs) throws SQLException ;
}
