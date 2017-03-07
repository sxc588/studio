package com.github.support.cbb.utils;

import static org.junit.Assert.*;
import java.util.Date;
import org.junit.Test;
import com.github.support.cbb.utils.bean.Book;

public class WebClientUtils
{

	
	
	
	/**
	 * @throws JAXBException
	 */
	@Test
	public void showMarshaller()
	{
		
	}

	/**
	 * @throws JAXBException
	 */
	@Test
	public void showUnMarshaller()
	{
	      String str = "<?xml version=\"1.0\" encoding=\"UTF-8\" standalone=\"yes\"?>" +  
		          "<book id=\"100\">" +  
		          "    <author>James</author>" +  
		           "   <calendar>2013-03-29T09:25:56.004+08:00</calendar>" +  
		            "  <price_1>23.45</price_1>" +  
		          "</book>";  
		        
		Book book = JaxbUtil.converyToJavaBean(str, Book.class);
		System.out.println(book);
	}

}
