package org.fkjava.action;
import java.util.List;
import org.fkjava.domain.User;
import org.fkjava.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action 满足三个要求： 1. 实现Action 接口，或 继承ActionSupport【推荐继承】 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class ViewUsersAction extends ActionSupport
{
	private static final long serialVersionUID = 2635886475870205495L;

	private List<User> users;

	public List<User> getUsers()
	{
		return users;
	}

	public void setUsers(List<User> users)
	{
		this.users = users;
	}

	@Autowired
	UserService userService;

	@Override
	public String execute()
	{
		users = userService.getAll();
		return SUCCESS;
	}
}
