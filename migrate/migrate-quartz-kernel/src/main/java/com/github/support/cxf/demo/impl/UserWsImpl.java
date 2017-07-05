package com.github.support.cxf.demo.impl;


import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import javax.ws.rs.core.Feature;
import org.jasypt.util.numeric.StrongIntegerNumberEncryptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.support.cxf.demo.UserWs;
import com.sun.tools.xjc.reader.xmlschema.bindinfo.BIConversion.User;

public class  UserWsImpl implements UserWs
{
	private static Logger logger = LoggerFactory.getLogger(UserWsImpl.class);

	@Override
	public User getUserById(String username)
	{
		logger.info("username");
		return null;
	}

	@Override
	public String login(String usr, String pwd)
	{
		logger.info("login " + usr +"with passwod:" + pwd);
		
		
		ExecutorService executor= Executors.newFixedThreadPool(1);
		Future<String> fute= executor.submit(new handlerLog(usr));

		return null;
	}

	@Override
	public User putUser(User user)
	{
		
		logger.info(user.toString());
		return null;
	}

}