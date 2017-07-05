package org.fkjava.action;
import org.fkjava.domain.User;
import org.fkjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.github.cbb.json.JSONUtil;
import com.opensymphony.xwork2.Action;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class LoginAction implements Action
{
	private User user;

	public User getUser()
	{
		return user;
	}

	public void setUser(User user)
	{
		this.user = user;
	}

	@Autowired
	UserService userService = new UserService();

	@Override
	public String execute()
	{
		// User validateUsr = userService.validateLogin(user);
		// if (validateUsr == null)
		// {
		// return ERROR;
		// }
		return SUCCESS;
	}

	public String registUser()
	{
		userService.add(user);
		String json = JSONUtil.toJson(user);
		System.err.println(json);
		return SUCCESS;
	}

}
