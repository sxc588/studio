package com.github.support.dbaccess.service;

import java.util.Date;
import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.support.dbaccess.dto.MonSysConfig;
import com.github.support.utils.HwNetUtil;


@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class MonSysConfigServcieTest
{
	@Autowired
	private BasicDataSource ds;

	@Autowired
	private MonSysConfigServcie service;

	// @Ignore
	@Test
	public void test()
	{

		long begin = System.currentTimeMillis();
		for (int key=10000; key<90000;key++)
		{
			String value = "value" + key;
			String description ="description" +key;
			Date lastUpdateTime = new Date();
			String lastUpdateBy = HwNetUtil.getHostNameL();
			
			MonSysConfig config = new MonSysConfig(key, value, description, lastUpdateTime, lastUpdateBy);
			
			service.insert(config);
		}
		
		long End = System.currentTimeMillis();
		
		System.err.println("" + (End-begin));
		
//		List<MonSysConfig> kk = service.getList(0, 10);
//		System.err.println(kk.size());
	}

	@Test
	public void test2()
	{

		long begin = System.currentTimeMillis();
		List<MonSysConfig> values = service.getList(0, 1);
		
		System.out.println(JSON.toJSON(values));
		
		long End = System.currentTimeMillis();
		
		System.out.println("--->" + (End-begin));
		
//		List<MonSysConfig> kk = service.getList(0, 10);
//		System.err.println(kk.size());
	}
	
	@Test
	public void selectByPrimaryKeyTest()
	{

		for (int i=0; i<100; i++)
		{
		long begin = System.currentTimeMillis();
MonSysConfig values = service.selectByPrimaryKey(10050+i);
		
	//	System.out.println(JSON.toJSON(values));
		
		long End = System.currentTimeMillis();
		
		System.out.println("--->" + (End-begin));
		}
//		List<MonSysConfig> kk = service.getList(0, 10);
//		System.err.println(kk.size());
	}
	
	
}
