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
		//��pageCountҳ
		int pageCount = 0;
		//��nowPageҳ
		int nowPage = 8;
		//pageSizeÿҳ��ʾ������
		int pageSize = 3;
		//��������
		List<BookInfo> books = null; 
		String strStates = request.getParameter("states");
		String strNowPage = request.getParameter("nowPage");
		if (strStates == null) {//��ʾ���п���ͼ�飺δ�ϼ������ϼܵ�
			strStates = "5";
		}
		if (strNowPage == null) {//��ʾ���п���ͼ�飺δ�ϼ������ϼܵ�
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
