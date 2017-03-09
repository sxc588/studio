package com.github.support.demo;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.github.support.entitlement.entity.User;


@Path(value="/rest02")  
public class RestHelloWordImpl implements RestHelloWorld
{
    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public String say(String name)
	{
		return name + "，您好！";
	}

    @GET  
    @Path("/user")
    @Produces("text/plain")
	@Override
	public String sayHello(User user)
	{
		return user.getUsername() + "，您好！";
	}

    @GET  
    @Path("/users")
    @Produces("application/json")
    @Consumes("application/json")
	@Override
	public List<User> getList(Long id)
	{
		List<User> list = new ArrayList<User>();

		Long sid = 1L;
		User user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);

		sid = 2L;
		user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);

		sid = 3L;
		user = new User(sid.toString(), "张三" + sid, 21);
		list.add(user);
		return list;
	}

}
