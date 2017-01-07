package com.github.support.jdbc.dao;

public class Book
{
	Integer Bid;
	String BookName;
	String BookType;
	double BookPic;
	Integer Count;
	public Integer getBid()
	{
		return this.Bid;
	}
	public void setBid(Integer bid)
	{
		this.Bid = bid;
	}
	public String getBookName()
	{
		return this.BookName;
	}
	public void setBookName(String bookName)
	{
		this.BookName = bookName;
	}
	public String getBookType()
	{
		return this.BookType;
	}
	public void setBookType(String bookType)
	{
		this.BookType = bookType;
	}
	public double getBookPic()
	{
		return this.BookPic;
	}
	public void setBookPic(double d)
	{
		this.BookPic = d;
	}
	public Integer getCount()
	{
		return this.Count;
	}
	public void setCount(Integer count)
	{
		this.Count = count;
	}

}
