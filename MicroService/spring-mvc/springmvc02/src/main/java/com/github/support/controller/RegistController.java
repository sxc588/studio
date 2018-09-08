package com.github.support.controller;

import java.io.File;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class RegistController
{
	@RequestMapping(value = "regist", method = RequestMethod.GET)
	public String regist(HttpServletRequest request, Model model)
	{model.addAttribute("msg", "username");
		return "/login/regist";
	}

	@RequestMapping(value = "registSuccess", method = RequestMethod.POST)
	public String registSuccess(HttpServletRequest request, Model model)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");

		if (RegistCheck.registCheck(username, password, age))
		{
			model.addAttribute("username", username);
			return "login";
		} else
		{
			return "regist2";
		}
	}
	
	
	@RequestMapping(value = "list", method = RequestMethod.GET)
	public String list(HttpServletRequest request, Model model)
	{
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String age = request.getParameter("age");

		if (RegistCheck.registCheck(username, password, age))
		{
			model.addAttribute("username", username);
			return "/login/listGrid";
		} else
		{
			return "/login/listGrid";
		}
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