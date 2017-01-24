package com.wangwang.servlet.bookInfo;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.entity.BookInfo;

public class FindAllBookInfoServlet extends HttpServlet {


	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//共pageCount页
		int pageCount = 0;
		//第nowPage页
		int nowPage = 8;
		//pageSize每页显示多少条
		int pageSize = 3;
		//具体数据
		List<BookInfo> books = null; 
		String strStates = request.getParameter("states");
		String strNowPage = request.getParameter("nowPage");
		if (strStates == null) {//显示所有可用图书：未上架与以上架的
			strStates = "5";
		}
		if (strNowPage == null) {//显示所有可用图书：未上架与以上架的
			strNowPage = "1";
		} 
		nowPage = Integer.parseInt(strNowPage);
		int states = Integer.parseInt(strStates);
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		
		pageCount = bookInfoDAO.getPageCount(pageSize, states);
		books = bookInfoDAO.getNowPageData(nowPage, pageSize, states);
		
		request.setAttribute("pageCount", pageCount);
		request.setAttribute("pageSize", pageSize);
		request.setAttribute("nowPage", nowPage);
		request.setAttribute("books", books);
		request.setAttribute("states", states);
		
		
		request.getRequestDispatcher("/background/bookInfoList.jsp").forward(request, response); 
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
		throws ServletException, IOException {
		this.doGet(request, response);
	}
	

}
