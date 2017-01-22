package org.fkjava.action;
import org.fkjava.domain.User;
import org.fkjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.opensymphony.xwork2.Action;



/**
 * 1. 实现Action 接口，或 继承ActionSupport【推荐】 
 * 2. 数据fild , 提供 setter，getter 方法
 * 3. 无构造参数的构造器
 * @author Administrator
 *
 */
@Service
public class LoginAction implements Action
{
	User user;
	
	
	public User getUsr()
	{
		return user;
	}

	public void setUsr(User usr)
	{
		this.user = usr;
	}

	
	@Autowired
	UserService userService; 
	
	@Autowired
	ApplicationContext ctx; 

	@Override
	public String execute() throws Exception
	{
		User validateUsr = userService.validateLoin(user);
		if (validateUsr == null)
		{
			return ERROR;
		}
		
		return SUCCESS;
	}
}
