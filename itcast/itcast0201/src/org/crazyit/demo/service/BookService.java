package org.crazyit.demo.service;

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
public class BookService
{
	//������ģ��ӳ־ô洢�豸�����ݿ⣩��ȡ��������
	private String[] books = new String[] {
			"���Java����" ,
			"���Android����" ,
			"������Java EE��ҵӦ��ʵս",
			"���Ajax����",
			"���XML����",
		};
	//ҵ���߼��������÷�������ȫ��ͼ��
	public String[] getLeeBooks()
	{
		return books;
	}
}

