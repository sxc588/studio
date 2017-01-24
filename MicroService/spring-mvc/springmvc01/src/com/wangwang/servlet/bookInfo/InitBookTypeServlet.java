package com.wangwang.servlet.bookInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

public class InitBookTypeServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		List<BookType> bookTypes = bookTypeDAO.findAll();

		request.setAttribute("bookTypes", bookTypes);
		request.getRequestDispatcher("/background/saveBookInfo.jsp").forward(request, response);
		
	}

}
