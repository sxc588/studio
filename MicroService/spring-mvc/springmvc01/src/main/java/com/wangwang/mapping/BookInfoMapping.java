package com.wangwang.mapping;

import java.sql.ResultSet;
import java.sql.SQLException;

import com.wangwang.db.EntityMapping;
import com.wangwang.entity.BookInfo;

public class BookInfoMapping implements EntityMapping {

	@Override
	public BookInfo mapping(ResultSet rs) throws SQLException {
		BookInfo bookInfo = new BookInfo(
				rs.getInt("bookId"), 
				rs.getString("bookName"), 
				rs.getInt("bookTypeId"), 
				rs.getString("pbName"), 
				rs.getString("author"), 
				rs.getString("context"), 
				rs.getString("smallImg"), 
				rs.getString("bigImg"), 
				rs.getFloat("price"), 
				rs.getDate("pbDate"), 
				rs.getFloat("ygcPrice"), 
				rs.getInt("bookStates"));
		return bookInfo;
		
	}
}
