package com.github.support.demo;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.github.support.entitlement.entity.User;

@Path("/resthellowrld")
public interface RestHelloWorld
{
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/say/{name}")
	public String say(@PathParam("name")
	String name);

	@GET
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/sayHello/{name}")
	public String sayHello(@PathParam("user")
	User user);

	@GET
	@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	@Path("/getList/{id}")
	public List<User> getList(@PathParam("id")
	Long id);

}
