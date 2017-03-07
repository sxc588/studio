package com.github.support.pbi.ws;

import java.sql.SQLException;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@WebService
public interface PBIWs
{
	String sayHello(@WebParam(name = "foo")
	String foo);

	@RequestMapping(value = "xml", method = RequestMethod.POST)
	@Path("/ddd")
	public String executeQuery(
								final String driver,
								final String URL,
								final String username,
								final String password,
								final String sql) throws SQLException;
}
