package com.github.support.cxf.demo.impl;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.jws.WebService;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.UriInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.support.mapper.MigratonErrLogMapper;
import com.github.support.model.MigratonErrLog;

// @Produces：响应内容 MIME 类型。如
// @Produces(MediaType.TEXT_PLAIN)
// @Produces( { MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON })

//@PathParam("contact")：该注释将参数注入方法参数的路径。其他可用的注释有 @FormParam、@QueryParam 等。 


@Service
@Path("/dddd")
public class Hellworld
{
	
	//@Context： 使用该注释注入上下文对象，比如 Request、Response、UriInfo、ServletContext 等。
	@Context
	HttpServletRequest servletRequest;
	
	@Context
	HttpServletResponse servletResponse;
	
	@Context
	private UriInfo uriInfo;

	@Context
	ServletContext  servletContext;

	/**
	 * 简单服务方法
	 * 
	 * @param input
	 *            访问地址：http://localhost:8080/rest/ddd/surpolicy/sendString/queryParams_aa
	 * @return
	 */
	@GET
	@Path("/sendString/{input}")
	@Produces(MediaType.TEXT_PLAIN)
	public String sendStringParam(@PathParam("input")
	String input)
	{
		System.out.println("接收的参数： \r\n" + input);
		String tReturn = "成功返回";
		return tReturn;
	}

}
