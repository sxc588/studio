package com.github.support.controller.report;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.DataBinder;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.support.quartz.model.User;
import com.github.support.validator.UserValidator;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/ChangeController")
public class ChangeController {
	private static Logger log = LoggerFactory.getLogger(ChangeController.class);

	// 我们知道在Controller类中通过@InitBinder标记的方法只有在请求当前Controller的时候才会被执行
	// 所以在这里注册校验器
	@InitBinder
	public void initBainder(DataBinder binder) {
		binder.replaceValidators(new UserValidator());

	}

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		model.addAttribute(new User());
		return "/hello/login";
	}

	// 处理登录表单
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(@Validated User user, BindingResult br) {

		if (br.hasErrors()) {
			return "hello/login";
		}
		return "--";
	}
}
