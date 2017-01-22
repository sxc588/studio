package org.fkjava.action;
import com.opensymphony.xwork2.Action;



/**
 * 1. 实现Action 接口，或 继承ActionSupport【推荐】 
 * 2. 数据fild , 提供 setter，getter 方法
 * 3. 无构造参数的构造器
 * @author Administrator
 *
 */
public class LoginAction implements Action
{

	public String execute() throws Exception
	{
		return SUCCESS;
	}

}
