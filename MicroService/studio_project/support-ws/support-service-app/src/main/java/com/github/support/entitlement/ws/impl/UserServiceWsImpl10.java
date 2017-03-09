package com.github.support.entitlement.ws.impl;

import java.util.ArrayList;
import java.util.List;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import com.github.support.entitlement.Dao.UserDao;
import com.github.support.entitlement.entity.User;
import com.github.support.entitlement.ws.UserServiceWs;

@Path(value="/userservicews")  
public class UserServiceWsImpl10 implements UserServiceWs
{
	private  UserDao  userDao ; 

    @GET
    @Path("/add")
    @Produces(MediaType.APPLICATION_JSON)
	@Override
	public void insert(String userid, String username, String useremail, int userage)
	{
		User user= new  User(); 
		user.setUserage(userage); 
		user.setUseremail(useremail); 
		user.setUserid(userid); 
		user.setUsername(username); 
		userDao.insert(user); 
		System. out .println( "insert successfully!" );
	}

    @GET  
    @Path("/user")
    @Produces("text/plain")
	@Override
	public User getUserById(String userid)
	{
		return  userDao.findUserById(userid); 
	}

    @GET  
    @Path("/users")
    @Produces("application/json")
    @Consumes("application/json")
	@Override
	public List<User> getAllUsers()
	{
    	User user= new  User(); 
		user.setUserage(10); 
		user.setUseremail("useremail"); 
		user.setUserid("userid"); 
		user.setUsername("username"); 
		
		List<User> users= new ArrayList<User>();
		
		users.add(user);
    	
		return users; 
	}

}
