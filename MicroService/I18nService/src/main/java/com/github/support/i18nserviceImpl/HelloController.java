package com.github.support.i18nserviceImpl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@Controller("/hello")
public class HelloController
{
	Logger logger = LoggerFactory.getLogger(HelloController.class);

	@RequestMapping("/hello1")
	public String hello()
	{
		logger.info("Enter HelloController.hello");
	
		return "hello";
	}
	
	/***
	 * 首页 返回至/page/home.jsp页面
	 * @return
	 */
	@RequestMapping("index")
	public ModelAndView  index()
	{
		logger.info("Enter HelloController.hello");
		
		//创建模型跟视图，用于渲染页面。并且指定要返回的页面为home页面
		ModelAndView mav = new ModelAndView("home");
		return mav;
	}
}
