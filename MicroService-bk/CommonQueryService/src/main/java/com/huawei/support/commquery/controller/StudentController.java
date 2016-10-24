package com.huawei.support.commquery.controller;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.huawei.support.commquery.service.DynamicQuery;

/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@RestController
@RequestMapping("/student")
public class StudentController
{
	Logger logger = LoggerFactory.getLogger(StudentController.class);

	@RequestMapping("/list")
	public  ModelAndView  list() throws SQLException, JsonProcessingException
	{	
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
		ObjectMapper mapper = new ObjectMapper();
		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
		String jsonStr = mapper.writeValueAsString(result);
		
		logger.info(jsonStr);

		ModelAndView mav= new ModelAndView();
		
		mav.addObject("result",jsonStr);
		mav.setViewName("student/list");
		return mav;
	}
	@RequestMapping("/list2")
	public  List<Map<String, String>>  list2() throws SQLException, JsonProcessingException
	{	
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
//		ObjectMapper mapper = new ObjectMapper();
//		mapper.enable(SerializationFeature.WRAP_ROOT_VALUE);
//		String jsonStr = mapper.writeValueAsString(result);
//		
//		logger.info(jsonStr);
//
//		ModelAndView mav= new ModelAndView();
//		
//		mav.addObject("result",jsonStr);
//		mav.setViewName("student/list");
		return result;
	}
}
