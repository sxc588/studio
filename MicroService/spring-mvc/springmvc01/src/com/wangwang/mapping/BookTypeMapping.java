package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookType;

public class BookTypeMapping implements EntityMapping {
	
	/**
	 * ��rs��ǰ������ת��Ϊһ��ʵ�����
	 * @param rs
	 * @return ����ʵ����
	 * @throws SQLException
	 */
	@Override
	public BookType mapping(ResultSet rs) throws SQLException {
		//�ֶ���ʹ��
		BookType bookType = new BookType();
		bookType.setBookTypeId(rs.getInt("bookTypeId"));
		bookType.setParentId(rs.getInt("parentId"));
		bookType.setIsDelete(rs.getInt("isDelete"));
		bookType.setContext(rs.getString("context"));
		bookType.setBookTypeName(rs.getString("bookTypeName"));
		return bookType;
	}

}
