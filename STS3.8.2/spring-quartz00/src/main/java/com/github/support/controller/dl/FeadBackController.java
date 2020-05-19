package com.github.support.controller.dl;

import java.io.IOException;
import java.util.logging.SimpleFormatter;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能说明：系统配置项Action
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "/feadback")
public class FeadBackController extends SimpleFormatter {
	private static Logger log = LoggerFactory.getLogger(FeadBackController.class);

	

	@RequestMapping("/")
	public String upload(HttpServletRequest req)
			throws IllegalStateException, IOException {
		
		
		
		return "/settings/feadbackEdit";
	}  
	
	
}
