package com.github.support.controller.debug;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.github.support.utils.PingUtils;
import com.github.support.utils.PtResoult;
import com.github.support.utils.TelnetUtils;

/**
 * 功能说明：ping and telnet util
 * 
 * @author Administrator
 *
 */
@Controller
@RequestMapping(value = "debug/pt")
public class PtController
{

	private static Logger log = LoggerFactory.getLogger(PtController.class);

	@RequestMapping(value = "/ping", method = RequestMethod.GET)
	@ResponseBody
	public PtResoult ping()
	{

		String host = "192.168.208.128";
		PtResoult result = PingUtils.ping(host);
		log.info(JSON.toJSONString(result));
		return result;
	}

	@RequestMapping(value = "/telnet", method = RequestMethod.GET)
	@ResponseBody
	public PtResoult telnet()
	{

		String host = "192.168.208.128";
		int port = 8080;
		PtResoult result = TelnetUtils.telnet(host, port);
		log.info(JSON.toJSONString(result));
		return result;
	}

}
