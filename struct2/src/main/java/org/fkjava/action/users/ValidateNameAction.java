package org.fkjava.action.users;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.log4j.Logger;
import org.fkjava.action.JSONUtil;
import org.fkjava.domain.User;
import org.fkjava.service.AjaxObject;
import org.fkjava.service.AssociatedPersonnelService;
import org.fkjava.service.JSON;
import org.fkjava.service.UserService;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;

/**
 * Action 满足三个要求： 
 * 1. 实现Action 接口，或 继承ActionSupport【推荐继承】
 * 2. 数据fild , 提供
 * setter，getter 方法 3. 无构造参数的构造器
 */
@Controller
public class ValidateNameAction extends ActionSupport
{
	public String getUserName()
	{
		return userName;
	}

	public void setUserName(String userName)
	{
		this.userName = userName;
	}

	private static final long serialVersionUID = 2635886475870205495L;

	private static Logger log = Logger.getLogger(ValidateNameAction.class);


	private String  userName;



	// @Autowired
	UserService userService = new UserService();

	private String tip;

	public InputStream getTip() throws Exception
	{
		byte [] buf= tip.getBytes("UTF-8");
		
		InputStream is = new ByteArrayInputStream(buf);
		return is;
	}
	
	/**
	 * 注册时用户名校验
	 */
	@Override
	public String execute()
	{
		System.err.println("Validate name:" + getUserName());
		
		User userDb = userService.validateUser(getUserName());
		
		if (userDb != null)
		{
			tip  = "<span style='color:red'><b>" + getUserName()+ "</b>已经存在，请换一个名字再试！</sapn>";
		}
		else 
		{
			tip  = "<span style='color:green'><b>" + getUserName()+ "</b>校验通过，您可以继续！</sapn>";
		}
		return SUCCESS;
	}
}
