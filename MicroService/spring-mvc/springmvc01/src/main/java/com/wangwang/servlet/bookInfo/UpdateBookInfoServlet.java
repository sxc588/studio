package com.wangwang.servlet.bookInfo;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.wangwang.dao.BookInfoDAO;
import com.wangwang.dao.Tool;
import com.wangwang.entity.BookInfo;

public class UpdateBookInfoServlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
	throws ServletException, IOException {
		this.doPost(request, response);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int bookId = Integer.parseInt(request.getParameter("bookId"));
		String author = request.getParameter("author");
		String context = request.getParameter("context");
		String bookName = request.getParameter("bookName");
		String smallImg = request.getParameter("smallImg");
		String bigImg = request.getParameter("bigImg");
		int bookStates = Integer.parseInt(request.getParameter("bookStates"));
		int bookTypeId = Integer.parseInt(request.getParameter("bookTypeId"));
		
		float price = Float.parseFloat(request.getParameter("price"));
		float ygcPrice = Float.parseFloat(request.getParameter("ygcPrice"));
		String date = request.getParameter("pbDate");
		String pbName = request.getParameter("pbName");
		Date pdDate = null;
		try {
			pdDate = Tool.conventStringToDate(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		
		BookInfo bookInfo = new BookInfo(bookName, bookTypeId, pbName, author, context.trim(), price, pdDate, ygcPrice);
		bookInfo.setSmallImg(smallImg);
		bookInfo.setBigImg(bigImg);
		bookInfo.setBookStates(bookStates);
		bookInfo.setBookId(bookId);
		BookInfoDAO bookInfoDAO = new BookInfoDAO();
		
		String msg = "ʧ��";
		String returnPath = "/FindBookInfoByIdServlet?bookId=" + bookId;
		if (bookInfoDAO.update(bookInfo)) {
			msg = "�ɹ�";
			returnPath = "/FindAllBookInfoServlet";
		}
		//��ʾ��Ϣ
		request.setAttribute("msg", "�޸�ͼ����Ϣ" + msg);
		//����·��
		request.setAttribute("returnPath", returnPath);
		request.getRequestDispatcher("/background/message.jsp").forward(request, response);
		
		
	}

}
