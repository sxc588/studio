package com.github.support.intercepters;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {
	@RequestMapping(value = "/login")
	public String login(HttpSession session, String username, String password) throws Exception {
		System.out.println("-----login------");
		// 在Session里保存信息
		session.setAttribute("username", username);
		// 重定向
		return "hello";
	}

	@RequestMapping(value = "/logout")
	public String logout(HttpSession session) throws Exception {
		// 清除Session
		session.invalidate();

		return "hello";
	}

}
