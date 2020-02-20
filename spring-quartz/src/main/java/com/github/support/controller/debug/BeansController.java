package com.github.support.controller.debug;

import java.util.HashMap;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "debug/beans")
public class BeansController
{
	@Autowired
	private ApplicationContext context;

	private static Logger log = LoggerFactory.getLogger(BeansController.class);

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "", method = RequestMethod.GET)
	@ResponseBody
	public Map<String, String> login()
	{
		String[] names = context.getBeanDefinitionNames();
		Map<String, String> beanMap = new HashMap<String, String>();
		for (String name : names)
		{
			Object obj = context.getBean(name);
			String className = obj.getClass().getName();

			beanMap.put(name, className);
		}
		return beanMap;
	}
}
