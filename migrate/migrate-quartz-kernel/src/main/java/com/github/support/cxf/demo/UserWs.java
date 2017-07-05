package com.github.support.cxf.demo;

import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

/**
 * @FormParam
 * @PathParam
 * @QueryParam
 * @HeaderParam
 * @CookieParam
 * @MatrixParam
 */
@WebService
@Path("/wserWs")
public interface UserWs
{
	@GET
	@Path("/user")
	User getUserById(@QueryParam("username") String username);

	@GET
	@Path("/login")
	public String login(@QueryParam("username") String usr, @QueryParam("password") String pwd);

	@POST
	@Path("/user")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	User putUser(User user);
}