package com.wangwang.test;

import java.util.List;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;


public class TestBookTypeDAO {
	public static void main(String[] args) {
		TestBookTypeDAO testBookTypeDAO = new TestBookTypeDAO();
		//testBookTypeDAO.testUpdate();
		testBookTypeDAO.testFindById();
		//testBookTypeDAO.testSave();
		//testBookTypeDAO.testUpdate1();
		//testBookTypeDAO.testFindAll();
		
	}
	public void testFindById() {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = bookTypeDAO.findById(1);
		System.out.println(bookType );	
	}
	public void testUpdate() {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = new BookType(0, "历史", "历史小说");
		bookType.setIsDelete(2);
		bookType.setBookTypeId(9);
		System.out.println(bookTypeDAO.update(bookType));
		
	}
	public void testSave() {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = new BookType(0, "历史", "历史小说");
		bookType.setIsDelete(2);
		System.out.println(bookTypeDAO.save(bookType));
		
	}
	public void testUpdate1() {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		System.out.println(bookTypeDAO.updateIsDelete(9));
		
	}
	public void testFindAll() {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();
		for (BookType bookType : bookTypes) {
			System.out.println(bookType );	
		}
		
	}
}
