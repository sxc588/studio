package com.wangwang.dao;

import java.sql.SQLException;
import java.util.List;

import com.wangwang.db.JdbcTemplate;
import com.wangwang.entity.BookType;
import com.wangwang.mapping.BookTypeMapping;

public class BookTypeDAO {
	private JdbcTemplate jdbcTemplate = new JdbcTemplate();
	public BookType findById(int id) {
		BookType bookType = null; 
		String sql = "select bookTypeId, parentId, bookTypeName, context,isDelete from  booktype where bookTypeId = " + id;
		try {
			List entitys = jdbcTemplate.query(sql, new BookTypeMapping());
			bookType = (BookType)entitys.get(0);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookType;
	}

	public boolean update(BookType bookType) {
		String sql = 
				"update booktype " +
				"set parentId = ?, 	" +
				"	bookTypeName=?, " +
				"	isdelete=?, " +
				"	context=? "+
				"where " +
				"	booktypeId= ?";
		Object[] values = new Object[]{
			bookType.getParentId(), 
			bookType.getBookTypeName(),
			bookType.getIsDelete(),
			bookType.getContext(), 
			bookType.getBookTypeId()};
//		values[0] = bookType.getParentId();
//		values[1] = bookType.getParentId();
//		values[2] = bookType.getParentId();
//		values[3] = bookType.getParentId();
//		values[4] = bookType.getParentId();
		int rows = 0;
		try {
			//rows = jdbcTemplate.update(sql, values);
			rows = jdbcTemplate.update(sql, values);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rows == 1);
	}

	public boolean save(BookType bookType) {
		String sql = "insert into booktype(parentId, bookTypeName, context, isDelete) values(?, ?, ?, ?)";
		Object[] values = new Object[]{bookType.getParentId(), bookType.getBookTypeName(), bookType.getContext(), bookType.getIsDelete()};
		int rows = 0;
		try {
			//rows = jdbcTemplate.update(sql, values);
			rows = jdbcTemplate.update(sql, bookType.getParentId(), bookType.getBookTypeName(), bookType.getContext(), bookType.getIsDelete());
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return (rows == 1);
	}
	/**
	 * 逻辑删除
	 * @param id
	 * @return
	 */
	public boolean updateIsDelete(int id) {
		String sql = "update booktype set isdelete = 2 where booktypeId = " + id;
		try {
			return (jdbcTemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
	}
	
	/**
	 * 物理删除
	 * @param id
	 * @return
	 */
	public boolean delete(int id) {
		String sql = "delete from  booktype where booktypeId = " + id;
		try {
			return (jdbcTemplate.update(sql) == 1);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return  false;
	}
	
	public List<BookType> findAll() {
		String sql = "select bookTypeId, parentId, bookTypeName, context,isDelete from  booktype ";
		List<BookType> bookTypes = null;
		try {
			bookTypes = jdbcTemplate.query(sql, new BookTypeMapping());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return bookTypes;
	}
	
}
