package com.github.support.dbaccess.service;

import java.util.List;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.HelloLucene;
import com.github.support.dbaccess.dto.MonScheduleJob;
import com.github.support.dbaccess.service.MonScheduleJobService;
import com.github.support.utils.json.GsonUtil;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class MonScheduleJobServiceTest
{
	@Autowired
	private BasicDataSource ds;

	@Autowired
	private MonScheduleJobService service;

	@Test
	public void testsearch()
	{
		HelloLucene helloLucene = new HelloLucene();
		helloLucene.index();
		helloLucene.search("AAA");
	}

	@Test
	public void test()
	{
		HelloLucene helloLucene = new HelloLucene();
		helloLucene.index();
		helloLucene.search("AAA");
		System.err.println(ds.getUsername());
		System.err.println(ds.getPassword());
		System.err.println(ds.getUrl());
		System.err.println(ds.getMaxActive());
		System.err.println(ds.getMaxActive());
		System.err.println(ds.getMaxIdle());
		System.err.println(ds.getMinIdle());
	}
	
	@Test
	public void testA()
	{
		MonScheduleJob tt = service.selectByPrimaryKey(15L);
		
		String json = JSON.toJSONString(tt);
		System.err.println(json);
		
	}

	
	@Test
	public void getList()
	{
		List<MonScheduleJob> tt = service.getList(2,10);

		System.err.println(	tt.size());
		String json = JSON.toJSONString(tt);
		System.err.println(json);
		
		String json2 = GsonUtil.gsonString(tt);
		System.err.println(json2);
	}

}
