package com.github.support.entitlement.ws;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.github.support.entitlement.entity.User;

@Path(value="/userservicews")  
public interface UserServiceWs
{
    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	public void insert(String userid, String username, String useremail, int userage);
	

    @GET  
    @Path("/user")
    @Produces("text/plain")
	public User getUserById(String userid);
	
    @GET  
    @Path("/users")
    @Produces("application/json")
    @Consumes("application/json")
	public List<User> getAllUsers();
}
