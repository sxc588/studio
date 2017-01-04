package com.github.support.mvc.controller;

import java.io.IOException;
import java.util.Date;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.RequestToViewNameTranslator;
import com.github.support.entitement.mybatis.model.User;
import com.github.support.filter.SessionKeyContent;
import com.github.support.mvc.service.UserServiceI;

@Controller
@RequestMapping("/user")
public class UserController
{
	private static Logger logger = org.apache.log4j.Logger.getLogger(UserController.class);
	// private UserServiceI userService;
	//
	//
	// public UserServiceI getUserService()
	// {
	// return userService;
	// }
	//
	// @Autowired
	// public void setUserService(UserServiceI userService)
	// {
	// this.userService = userService;
	// }
	//
	//
	// @RequestMapping("/helloworld")
	// public String helloWorld(Model model, HttpServletRequest request)
	// {
	// model.addAttribute("message", "spring mvc 他大爷你好！");
	// return "hellworld";
	// }
	//
	//
	//
	// @RequestMapping("/{id}/showUser")
	// public String showUser(@PathVariable String id, HttpServletRequest
	// request)
	// {
	//
	// User u = userService.getUserById(id);
	// request.setAttribute("user", u);
	// return "showUser";
	// }
	//
	//

	@RequestMapping("/login")
	public String login(HttpServletRequest request, HttpServletResponse response)
	{
		System.err.println("---- 登录验证-----");

		String username = request.getParameter("username");

		String password = request.getParameter("password");

		Cookie cookie = new Cookie("user", username + "," + password);

		cookie.setMaxAge(2 * 60);

		response.addCookie(cookie);

		User currentuser = new User();
		currentuser.setUsrname(username);
		currentuser.setPassword(password);

		HttpSession session = request.getSession();

		session.setAttribute("user", currentuser);

		request.setAttribute("currentuser", currentuser);
		return "redirect:/main.jsp";
	}

	@RequestMapping("/ajax0")
	public User ajax0()
	{

		User currentuser = new User();
		currentuser.setUsrname("username");
		currentuser.setPassword("password");
		return currentuser;
	}

	@RequestMapping("/ajax")
	public @ResponseBody User ajax()
	{
		System.err.println("triagle ==>ajas" + new Date().getTime());
		User currentuser = new User();
		currentuser.setUsrname("username");
		currentuser.setPassword("password");
		return currentuser;
	}

	@RequestMapping("/login2")
	public void login2(HttpServletRequest request, HttpServletResponse response) throws IOException
	{
		System.err.println("triagle ==>ajas" + new Date().getTime());
		User currentuser = new User();
		currentuser.setUsrname("username");
		currentuser.setPassword("password");

		request.getSession().setAttribute(SessionKeyContent.SESSION_KEY_OBJ_USER_BEAN, "aaaa");

		String uri = (String) request.getSession().getAttribute(SessionKeyContent.SESSION_KEY_URL);

		System.err.println(uri);
		response.sendRedirect(uri);
	}

}
