package com.github.support.commquery.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.github.support.commquery.service.DynamicQuery;



/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@Controller("/user")
public class UserController
{
	Logger logger = LoggerFactory.getLogger(UserController.class);

	
//	@RequestMapping(value="xml", method=RequestMethod.POST)  
//	public @ResponseBody String readXml(@RequestBody JavaBean bean) {  
//	   return "Read from XML " + bean;  
//	}  
//	  
	@RequestMapping(value="xml", method=RequestMethod.GET)  
	public @ResponseBody  List<Map<String, String>> writeXml() throws SQLException {  
	 
	
		// 数据库的连接驱动，一般是不需要变的
		String DRIVER = "com.mysql.jdbc.Driver";
		// 数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
		String URL = "jdbc:mysql://localhost:3306/test";
		// 登录账户
		String DBNAME = "root";
		// 登录的密码
		String DBPASS = "root";
		String sql = "select count(*) as count  from account where 1=1";
		
		List<Map<String, String>> result = DynamicQuery.executeQuery(DRIVER, URL, DBNAME, DBPASS, sql);
		
		return result;  
	}  

	
	
	@RequestMapping("hello")
	public String hello()
	{
		logger.info("Enter HelloController.hello");
	
		System.out.println("Enter HelloController.hello");
		return "hello";
	}
	
	/***
	 * 用户登陆
	 * <p>
	 * 注解配置，只允许POST提交到该方法
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public ModelAndView login(String username, String password)
	{
		// 验证传递过来的参数是否正确，否则返回到登陆页面。
		if (this.checkParams(new String[]
		{username, password}))
		{
			// 指定要返回的页面为succ.jsp
			ModelAndView mav = new ModelAndView("succ");
			// 将参数返回给页面
			mav.addObject("username", username);
			mav.addObject("password", password);
			return mav;
		}
		return new ModelAndView("home");
	}
	
	/***
	 * 另一种参数传递的形式
	 * 通过request来处理请求过来的参数。
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping(value="login2",method=RequestMethod.POST)
	public ModelAndView login2(String username,String password,HttpServletRequest request){
		request.setAttribute("username", username);
		request.setAttribute("password", password);
		return new ModelAndView("succ");
	}

	/***
	 * 验证参数是否为空
	 * 
	 * @param params
	 * @return
	 */
	private boolean checkParams(String[] params)
	{
		for (String param : params)
		{
			if (param == "" || param == null || param.isEmpty())
			{
				return false;
			}
		}
		return true;
	}
}
