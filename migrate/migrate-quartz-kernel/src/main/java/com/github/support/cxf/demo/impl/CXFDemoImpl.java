package com.github.support.cxf.demo.impl;

import java.sql.SQLException;
import java.util.Calendar;
import javax.jws.WebService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.github.support.cxf.demo.CXFDemo;
import com.github.support.cxf.demo.DynamicQuery;
import com.github.support.mapper.MigratonErrLogMapper;
import com.github.support.model.MigratonErrLog;


@Service
@WebService(endpointInterface = "com.github.support.cxf.demo.CXFDemo", serviceName="CXFDemo")
public class CXFDemoImpl implements CXFDemo
{

	
//	@Autowired
	MigratonErrLogMapper logMapper;
	
	@Override
	public String sayHello(String userName)
	{
		try
		{
			MigratonErrLog log = new MigratonErrLog();
			log.setEntityName("ddfdf");
		
			logMapper.insertSelective( log);
		}
		catch (Throwable e)
		{
			System.err.println("DDDDDDDDDDDDDDDDDD"+e);
		}

		
		return "Hello " + userName + ", currentTime is "  + Calendar.getInstance().getTime();
	}

	@RequestMapping(value="xml", method=RequestMethod.POST)  
	@Override
	public String executeQuery(String driver, String URL, String username, String password, String sql) throws SQLException
	{
		return DynamicQuery.executeQuery(driver, URL, username, password, sql).toString();
	}

}
