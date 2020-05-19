package com.github.support.controller.tools;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestBody;
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
@RequestMapping(value = "tools/net")
public class PingTelenetUtilController extends SimpleFormatter {
	private static Logger log = LoggerFactory.getLogger(PingTelenetUtilController.class);

	// 这个方法主要是跳转到登录页面
	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	public String edit(HttpServletRequest request, ModelMap modelMap) {
		log.info(">>edit");
		long begin = System.currentTimeMillis();

	    List<Host> hostList = new ArrayList<Host>();
		
	    hostList.add(new Host("HostNeme01"));
	    hostList.add(new Host("HostNeme02"));
	    hostList.add(new Host("HostNeme03"));
	    hostList.add(new Host("HostNeme04"));
	    hostList.add(new Host("HostNeme05"));
	    hostList.add(new Host("HostNeme06"));
	    hostList.add(new Host("HostNeme07"));

	    modelMap.put("hostList", hostList);

		long end = System.currentTimeMillis();
		log.info(">>edit.save" + (end - begin));
		return "/tools/pingUtil";
	}

	@RequestMapping(value = "/telnet", method = RequestMethod.GET)
	@ResponseBody
	public String test(HttpServletRequest request, ModelMap modelMap) {
		log.info(">>edit");
		long begin = System.currentTimeMillis();

	    List<Host> hostList = new ArrayList<Host>();
		
	    hostList.add(new Host("HostNeme01"));
	    hostList.add(new Host("HostNeme02"));
	    hostList.add(new Host("HostNeme03"));
	    hostList.add(new Host("HostNeme04"));
	    hostList.add(new Host("HostNeme05"));
	    hostList.add(new Host("HostNeme06"));
	    hostList.add(new Host("HostNeme07"));

	    modelMap.put("hostList", hostList);

		long end = System.currentTimeMillis();
		log.info(">>edit.save" + (end - begin));
		return "/tools/telnet";
	}

	@RequestMapping(value = "/ping", method = RequestMethod.POST)
	@ResponseBody
	public List<String> ping(@RequestBody ArrayList<String> ids) {
		System.out.println("List==" + ids);
		return ids;
	}

	

}
