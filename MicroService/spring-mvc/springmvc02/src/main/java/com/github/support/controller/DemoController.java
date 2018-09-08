package com.github.support.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.spi.LocationAwareLogger;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class DemoController
{
	private static Logger logger = LoggerFactory.getLogger(DemoController.class);
	
	@RequestMapping(value = "demo1", method = RequestMethod.GET)
	public ModelAndView demo1(HttpServletRequest request, HttpServletResponse reponse)
	{
	
		System.err.println("DemoController -- demo1" );
		return null;
	}
	
	
	@RequestMapping(value = "demo2", method = RequestMethod.GET)
	public ModelAndView demo1(HttpServletRequest request, String user)
	{
	
		logger.info("DemoController -- demo2" + user);
		return null;
	}
	
	
	@RequestMapping(value = "demo3", method = RequestMethod.GET)
	public void demo3(HttpServletRequest request, String user)
	{
		logger.info("DemoController -- demo1" + user);
	}

//	@RequestMapping(value = "/form/printContract")
//	public ResponseEntity<byte[]> printContract(ContractIreportForm form)throws Exception {
//		HttpHeaders headers = new HttpHeaders();
//	
//		//声明变量
//		File file = null ;
//		try {
//			file = new File("");
//			String downFileName = new String(("").getBytes("UTF-8"),"iso-8859-1");
//			headers.setContentDispositionFormData("attachment", downFileName);   
//		    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM); 
//		    form.setIsSuccess(SUCCESS);
//		} catch (Exception e) {
//			form.setIsSuccess(FAILURE);
//			form.setMsg(exMsg(e));
//		}
//		return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),    
//                headers, HttpStatus.CREATED);  
//	}
}