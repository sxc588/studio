package com.github.support.jdbc.dao;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.springframework.jdbc.core.JdbcTemplate;

public class BookDao
{

	private JdbcTemplate jdbcT;

	public List<Map<String, Object>> findALL()
	{
		String sql = "select * from BookInfo";
		return jdbcT.queryForList(sql);
	}

	public List<Book> findALLBooks()
	{
		List<Book> books = new ArrayList<Book>();;
		String sql = "select * from BookInfo";
		List<Map<String, Object>> list = jdbcT.queryForList(sql);
		Iterator<Map<String, Object>> iterator = list.iterator();
		Book book = null;
		while (iterator.hasNext())
		{
			Map<String, Object> map4book = (Map<String, Object>) iterator.next();
			book = new Book();
			book.setBid((Integer) map4book.get("bid"));
			book.setBookName((String) map4book.get("bookName"));
			book.setBookType((String) map4book.get("bookType"));
			book.setBookPic(((BigDecimal) map4book.get("bookPic")).doubleValue());
			book.setCount((Integer) map4book.get("count"));
			books.add(book);
		}
		return books;
	}
	public int delete(int bid)
	{
		String sql = "delete from BookInfo where bid =?";
		return jdbcT.update(sql, new Object[]
		{bid});
	}
	
	public List<Map<String, Object>> query(String sql , Integer ... values)
	{
		
		for (Integer value : values)
		{
			System.out.println(value.toString());
		}
		
		return null;
	//	return jdbcT.queryForList(sql,values);
	}
	public static void main(String[] args)
	{
		List<Book> books = new BookDao().findALLBooks();;
		for (Book book : books)
		{
			System.out.println(book.getBid() + "," + book.getBookName() + "," + book.getBookType());
		}
	}
}