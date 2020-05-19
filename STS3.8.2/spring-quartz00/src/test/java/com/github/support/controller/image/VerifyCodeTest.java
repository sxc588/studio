package com.github.support.controller.image;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.imageio.ImageIO;

import org.junit.Test;

public class VerifyCodeTest
{
	@Test
	public void testVerifyCode() throws IOException{
		Date now = new Date();
	    SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");

		
		VerifyCode code = new VerifyCode();
		BufferedImage image = code.createImage();
		ImageIO.write(image,"jpg",new File("d:/" + f.format(now) + code.getText() +  ".jpg"));
		System.out.println(code.getText());
	}

	

//	@Override
//	protected void service(HttpServletRequest request, HttpServletResponse response)
//			throws ServletException, IOException {
//		VerifyCode code = new VerifyCode();
//		BufferedImage image = code.createImage();
//		ImageIO.write(image,"jpg",response.getOutputStream());
//	}
//	<img src="VerifyCodeServlet.do">
	
}
