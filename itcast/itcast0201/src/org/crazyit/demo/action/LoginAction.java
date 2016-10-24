package org.crazyit.demo.action;

import com.opensymphony.xwork2.*;

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
// �̳�ActionSupport��ʵ��Action
public class LoginAction extends ActionSupport
{
	//���������ڷ�װ�û������������������
	private String username;
	private String password;
	// username���Ե�getter��setter����
	public String getUsername()
	{
		return username;
	}
	public void setUsername(String username)
	{
		this.username = username;
	}
	// password���Ե�getter��setter����
	public String getPassword()
	{
		return password;
	}
	public void setPassword(String password)
	{
		this.password = password;
	}
	// �����û������execute����
	public String execute() throws Exception
	{
		// ���û����������username����crazyit�������������Ϊleegangʱ��
		// ����success�ַ��������򷵻�error�ַ���
		if (getUsername().equals("crazyit")
			&& getPassword().equals("leegang"))
		{
			// ͨ��ActionContext�������WebӦ�õ�HTTP Session
			ActionContext.getContext().getSession()
				.put("user" , username);
			return SUCCESS;
		}
		else
		{
			return ERROR;
		}
	}
}
