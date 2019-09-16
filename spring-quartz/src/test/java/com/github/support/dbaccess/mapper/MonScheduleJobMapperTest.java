package com.github.support.dbaccess.mapper;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.HelloLucene;
import com.github.support.dbaccess.dto.MonScheduleJob;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class MonScheduleJobMapperTest {
	@Autowired
	private BasicDataSource ds;

	@Autowired
	private MonScheduleJobMapper mapper;

	@Test
	public void getList() {
		Map<String, Object> map = new HashMap<String, Object>();

		map.put("offset", 9);
		map.put("limit", 100);

		List<MonScheduleJob> tt = mapper.getList(map);

		System.err.println(tt.size());

		String json = JSON.toJSONString(tt);
		System.err.println(json);

	}

	@Test
	public void test() {
		System.err.println(ds.getUsername());
		System.err.println(ds.getPassword());
		System.err.println(ds.getUrl());
		System.err.println(ds.getMaxActive());
		System.err.println(ds.getMaxActive());
		System.err.println(ds.getMaxIdle());
		System.err.println(ds.getMinIdle());
	}

	@Test
	public void testA() {
		MonScheduleJob tt = mapper.selectByPrimaryKey(15L);

		String json = JSON.toJSONString(tt);
		System.err.println(json);

	}

	@Test
	public void testsearch() {
		HelloLucene helloLucene = new HelloLucene();
		helloLucene.index();
		helloLucene.search("AAA");
	}

}
