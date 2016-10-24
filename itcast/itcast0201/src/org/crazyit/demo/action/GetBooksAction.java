package org.crazyit.demo.action;

import com.opensymphony.xwork2.*;

import org.crazyit.demo.service.*;
/**
 * Description:
 * <br/>��վ: <a href="http://www.crazyit.org">���Java����</a>
 * <br/>Copyright (C), 2001-2012, Yeeku.H.Lee
 * <br/>This program is protected by copyright laws.
 * <br/>Program Name:
 * <br/>Date:
 * @author Yeeku.H.Lee kongyeeku@163.com
 * @version 1.0
 */
public class GetBooksAction implements Action
{
	// �����Բ������ڷ�װ�û����������
	// �����ڷ�װAction��Ҫ�����JSPҳ�����Ϣ
	private String[] books;
	// books���Ե�setter��getter����
	public void setBooks(String[] books)
	{
		this.books = books;
	}
	public String[] getBooks()
	{
		return books;
	}
	// �����û������execute����
	public String execute() throws Exception
	{
		// ��ȡSession�е�user����
		String user = (String)ActionContext.getContext()
			.getSession().get("user");
		// ���user���Բ�Ϊ�գ��Ҹ�����ֵΪcrazyit
		if (user != null && user.equals("crazyit"))
		{
			// ����BookServiceʵ��
			BookService bs = new BookService();
			// ��ҵ���߼�����ķ���ֵ���óɸ�Action������
			setBooks(bs.getLeeBooks());
			return SUCCESS;
		}
		else
		{
			return LOGIN;
		}
	}
}
