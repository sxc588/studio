package com.github.support.sysconfig.ws;

import java.sql.SQLException;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.support.sysconfig.dto.ConfigBean;

@WebService
public interface ConfigWs
{
	String sayHello(@WebParam(name = "foo")
	String foo);
	
	@RequestMapping(value = "xml", method = RequestMethod.POST)
	@Path("/config")
	public ConfigBean putConfig(ConfigBean config);
	
	
	@RequestMapping(value = "xml", method = RequestMethod.GET)
	@Path("/get")
	public ConfigBean getConfigByKey(final String key);
	
	
	@RequestMapping(value = "xml", method = RequestMethod.GET)
	@Path("/get")
	public ConfigBean getConfigsByParntKey(final String key);
	
	
	@RequestMapping(value = "xml", method = RequestMethod.DELETE)
	@Path("/del")
	public ConfigBean remove(final String key);
	
}
