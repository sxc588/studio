package com.huawei.support.commquery.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@Controller
public class HelloWorldController
{
	Logger logger = LoggerFactory.getLogger(HelloWorldController.class);

	@RequestMapping("/helloworld")
	public String hello(Model model)
	{
		logger.info("Enter ->HelloController.hello");
		model.addAttribute("messages", "你好，SpringMVC -- holloword 他大爷！");
		return "helloworld";
	}
}
