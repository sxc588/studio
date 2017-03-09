package com.github.weir;  
  
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
  
//@WebService(endpointInterface="com.weir.webservice.UserExit")  
@Path(value="/userexit")  
public class UserExitImpl implements UserExit {  
  
    @GET  
    @Path("/exitUser")
    @Produces("text/plain")
    public boolean exitUser() {  
        System.out.println("lllll");  
        return false;  
    }
    
}  