package com.github.support.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

@Controller
public class LoginController
{
	@RequestMapping(value = "hello", method = RequestMethod.GET)
	public String sayHello()
	{
		// model.addAttribute("msg", "Hello,World!");
		return "/login/login";
	}

	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String login(Model model, // 向前台页面传的值放入model中
			HttpServletRequest request)
	{ // 从前台页面取得的值
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String user_name = LoginCheck.check(username, password);
		if (user_name != null && user_name != "")
		{
			model.addAttribute("msg", user_name);
			return "/login/success";
		} else
		{
			return "/login/login2";
		}
	}
}