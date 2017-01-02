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
import com.github.support.i18nserviceImpl.DynamicQuery;

/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@Controller
public class HomeController
{
	Logger logger = LoggerFactory.getLogger(HomeController.class);

	
//	@RequestMapping(value="xml", method=RequestMethod.POST)  
//	public @ResponseBody String readXml(@RequestBody JavaBean bean) {  
//	   return "Read from XML " + bean;  
//	}  
//	  
	@RequestMapping({"/","/home"})  
	public @ResponseBody  String  showHomePage(Map<String, Object> model) throws SQLException {  
	 
		
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
				
		model.put("result", result);
	
		
		return "homedddddddddddddddd";
	}  
}
