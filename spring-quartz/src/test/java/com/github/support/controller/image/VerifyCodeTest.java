package com.github.support.controller.image;

import java.awt.image.BufferedImage;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.junit.Test;

public class VerifyCodeTest
{
	@Test
	public void testVerifyCode(){
		Date now = new Date();
	    SimpleDateFormat f = new SimpleDateFormat("yyyyMMddHHmmssSSS");
		VerifyCode vc = new VerifyCode();
		BufferedImage bi = vc.getImage();
		vc.outputImage(bi, f.format(now));
		System.out.println(vc.getText());
	}

}
