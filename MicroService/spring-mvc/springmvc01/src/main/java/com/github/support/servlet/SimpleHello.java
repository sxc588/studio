package com.github.support.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SimpleHello extends HttpServlet
{

	/**
	 * 
	 */
	private static final long serialVersionUID = 746732776233224400L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException
	{
		PrintWriter out = resp.getWriter();
		out.println("hello world.");
		out.close();
	}

}
