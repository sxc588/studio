package com.github.support.i18n.ws;

import java.sql.SQLException;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import javax.ws.rs.Path;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@WebService
@Path("/i18ns")
public interface I18nWS
{
	@WebMethod
	String sayHello(@WebParam(name = "username")String username);


	@RequestMapping(value = "xml", method = RequestMethod.POST)
	@Path("/ddd")
	public String executeQuery(
								final String driver,
								final String URL,
								final String username,
								final String password,
								final String sql) throws SQLException;

    @WebMethod  
    public String sayHello2(@WebParam(name = "username") String username);    

}