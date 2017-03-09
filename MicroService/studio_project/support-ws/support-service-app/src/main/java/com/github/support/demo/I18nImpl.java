package com.github.support.demo;

import java.util.Arrays;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


@Path(value="/i18n")  
public class I18nImpl
{
    @GET
    @Path("/domain/{domain}")
    @Produces(MediaType.APPLICATION_JSON)
	public List<String> geAvaiableType(@PathParam("domain") String domaintype)
	{
    	String langType ="zh,en,jp";
    	String[] array= langType.split(",");
    	List<String> langList = Arrays.asList(array);
		return langList;
	}  
}
