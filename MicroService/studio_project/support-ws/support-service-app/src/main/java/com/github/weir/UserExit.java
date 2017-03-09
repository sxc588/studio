package com.github.weir;  
  
import javax.ws.rs.GET;
import javax.ws.rs.Path;
  
//@WebService  
@Path(value="/userexit")  
public interface UserExit {  
  
    @GET  
    @Path("/exitUser")  
    public boolean exitUser();  
}  