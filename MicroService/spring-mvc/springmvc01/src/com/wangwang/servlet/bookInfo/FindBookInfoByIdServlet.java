package com.wangwang.servlet.bookInfo;


import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookInfo;
import com.wangwang.entity.BookType;

@SuppressWarnings("serial")
public class FindBookInfoByIdServlet extends HttpServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		int bookId = Integer.parseInt(request.getParameter("bookId"));
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		BookInfo book = bookInfoDAO.findById(bookId);
		request.setAttribute("book", book);
		
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();
		request.setAttribute("bookTypes", bookTypes);
		
		request.getRequestDispatcher("/background/updateBookInfo.jsp").forward(request, response);
		

	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		this.doGet(request, response);
	}

}
