package com.github.support.i18n.ws;

import java.sql.SQLException;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@WebService
@Path("/common")
public interface CommonQueryWS
{
	@RequestMapping(value = "xml", method = RequestMethod.POST)
	@Path("/query")
	public String executeQuery(
								final String driver,
								final String URL,
								final String username,
								final String password,
								final String sql) throws SQLException;
}