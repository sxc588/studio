package com.wangwang.servlet.bookType;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookTypeDAO;
import com.wangwang.entity.BookType;

public class SaveBookTypeServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		int parentId = Integer.parseInt(request.getParameter("parentId"));
		String bookTypeName = request.getParameter("bookTypeName");
		int isDelete = Integer.parseInt(request.getParameter("isDelete"));
		String context = request.getParameter("context");
		
		BookTypeDAO bookTypeDAO = new BookTypeDAO();
		BookType bookType = new BookType(parentId, isDelete, bookTypeName, context);
		/*BookType bookType = new BookType();
		bookType.setParentId(Integer.parseInt(request.getParameter("parentId")));
		bookType.setBookTypeName(bookTypeName);*/
		
		System.out.println(bookTypeDAO.save(bookType));
	}

}
