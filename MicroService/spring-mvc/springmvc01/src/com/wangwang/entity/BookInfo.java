package com.wangwang.entity;

import java.util.Date;

public class BookInfo {
	private int bookId;//int identity primary key,
	private String bookName;// varchar(20) not null,
	private int bookTypeId;// int not null,
	private String pbName;// varchar(20) not null,
	private String author;// varchar(20) not null,
	private String context;// varchar(40) ,
	private String smallImg;// varchar(20) ,
	private String bigImg;// varchar(20) ,
	private float price;// money not null,
	private Date pbDate;// datetime not null,
	private float ygcPrice;// money not null,
	private int bookStates;// 可用，上架，不可用
	
	public BookInfo() {
		super();
	}
	
	public BookInfo(String bookName, int bookTypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			float price, Date pbDate, float ygcPrice, int bookStates) {
		super();
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbDate = pbDate;
		this.ygcPrice = ygcPrice;
		this.bookStates = bookStates;
	}
	public BookInfo(String bookName, int bookTypeId, String pbName,
			String author, String context, float price, Date pbDate, float ygcPrice) {
		super();
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.price = price;
		this.pbDate = pbDate;
		this.ygcPrice = ygcPrice;

	}
	public BookInfo(int bookId, String bookName, int bookTypeId, String pbName,
			String author, String context, String smallImg, String bigImg,
			float price, Date pbDate, float ygcPrice, int bookStates) {
		super();
		this.bookId = bookId;
		this.bookName = bookName;
		this.bookTypeId = bookTypeId;
		this.pbName = pbName;
		this.author = author;
		this.context = context;
		this.smallImg = smallImg;
		this.bigImg = bigImg;
		this.price = price;
		this.pbDate = pbDate;
		this.ygcPrice = ygcPrice;
		this.bookStates = bookStates;
	}

	
	public int getBookId() {
		return bookId;
	}
	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getBookTypeId() {
		return bookTypeId;
	}
	public void setBookTypeId(int bookTypeId) {
		this.bookTypeId = bookTypeId;
	}
	public String getPbName() {
		return pbName;
	}
	public void setPbName(String pbName) {
		this.pbName = pbName;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getContext() {
		return context;
	}
	public void setContext(String context) {
		this.context = context;
	}
	public String getSmallImg() {
		return smallImg;
	}
	public void setSmallImg(String smallImg) {
		this.smallImg = smallImg;
	}
	public String getBigImg() {
		return bigImg;
	}
	public void setBigImg(String bigImg) {
		this.bigImg = bigImg;
	}
	public float getPrice() {
		return price;
	}
	public void setPrice(float price) {
		this.price = price;
	}
	public Date getPbDate() {
		return pbDate;
	}
	public void setPbDate(Date pbDate) {
		this.pbDate = pbDate;
	}
	public float getYgcPrice() {
		return ygcPrice;
	}
	public void setYgcPrice(float ygcPrice) {
		this.ygcPrice = ygcPrice;
	}
	public int getBookStates() {
		return bookStates;
	}
	public void setBookStates(int bookStates) {
		this.bookStates = bookStates;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((author == null) ? 0 : author.hashCode());
		result = prime * result + ((bigImg == null) ? 0 : bigImg.hashCode());
		result = prime * result + bookId;
		result = prime * result
				+ ((bookName == null) ? 0 : bookName.hashCode());
		result = prime * result + bookStates;
		result = prime * result + bookTypeId;
		result = prime * result + ((context == null) ? 0 : context.hashCode());
		result = prime * result + ((pbDate == null) ? 0 : pbDate.hashCode());
		result = prime * result + ((pbName == null) ? 0 : pbName.hashCode());
		result = prime * result + Float.floatToIntBits(price);
		result = prime * result
				+ ((smallImg == null) ? 0 : smallImg.hashCode());
		result = prime * result + Float.floatToIntBits(ygcPrice);
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BookInfo other = (BookInfo) obj;
		if (author == null) {
			if (other.author != null)
				return false;
		} else if (!author.equals(other.author))
			return false;
		if (bigImg == null) {
			if (other.bigImg != null)
				return false;
		} else if (!bigImg.equals(other.bigImg))
			return false;
		if (bookId != other.bookId)
			return false;
		if (bookName == null) {
			if (other.bookName != null)
				return false;
		} else if (!bookName.equals(other.bookName))
			return false;
		if (bookStates != other.bookStates)
			return false;
		if (bookTypeId != other.bookTypeId)
			return false;
		if (context == null) {
			if (other.context != null)
				return false;
		} else if (!context.equals(other.context))
			return false;
		if (pbDate == null) {
			if (other.pbDate != null)
				return false;
		} else if (!pbDate.equals(other.pbDate))
			return false;
		if (pbName == null) {
			if (other.pbName != null)
				return false;
		} else if (!pbName.equals(other.pbName))
			return false;
		if (Float.floatToIntBits(price) != Float.floatToIntBits(other.price))
			return false;
		if (smallImg == null) {
			if (other.smallImg != null)
				return false;
		} else if (!smallImg.equals(other.smallImg))
			return false;
		if (Float.floatToIntBits(ygcPrice) != Float
				.floatToIntBits(other.ygcPrice))
			return false;
		return true;
	}
	@Override
	public String toString() {
		return "BookInfo [bookId=" + bookId + ", bookName=" + bookName
				+ ", bookTypeId=" + bookTypeId + ", pbName=" + pbName
				+ ", author=" + author + ", context=" + context + ", smallImg="
				+ smallImg + ", bigImg=" + bigImg + ", price=" + price
				+ ", pbDate=" + pbDate + ", ygcPrice=" + ygcPrice
				+ ", bookStates=" + bookStates + "]";
	}
}
