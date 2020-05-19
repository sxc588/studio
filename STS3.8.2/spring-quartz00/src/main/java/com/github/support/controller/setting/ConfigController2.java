package com.github.support.controller.setting;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.support.controller.setting.dao.ConfigDto;
import com.github.support.controller.setting.service.IpUtil;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "setting/config2")
public class ConfigController2 extends SimpleFormatter {
	private static Logger log = LoggerFactory.getLogger(ConfigController2.class);

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/edit", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, Model model) {

		log.info(">>edit");
		long begin = System.currentTimeMillis();

		ConfigDto dto = new ConfigDto();
		dto.setLastUpdateTime(new Date());
		dto.setLastUpdateBy(IpUtil.getIpAddr());

		model.addAttribute(dto);
		long end = System.currentTimeMillis();
		log.info(">>edit.save" + (end - begin));
		return "/settings/configsEdit2";
	}

	@RequestMapping(value = "/index", method = RequestMethod.POST)
	@ResponseBody
	public List<Integer> test(@RequestBody ArrayList<Integer> ids) {
		System.out.println("List==" + ids);
		return ids;
	}

	
	

}
