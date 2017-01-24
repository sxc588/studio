package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookType;

public class BookTypeMapping implements EntityMapping {
	
	/**
	 * 把rs当前行数据转换为一个实体对象
	 * @param rs
	 * @return 具体实体类
	 * @throws SQLException
	 */
	@Override
	public BookType mapping(ResultSet rs) throws SQLException {
		//字段少使用
		BookType bookType = new BookType();
		bookType.setBookTypeId(rs.getInt("bookTypeId"));
		bookType.setParentId(rs.getInt("parentId"));
		bookType.setIsDelete(rs.getInt("isDelete"));
		bookType.setContext(rs.getString("context"));
		bookType.setBookTypeName(rs.getString("bookTypeName"));
		return bookType;
	}

}
