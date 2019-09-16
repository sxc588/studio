package com.github.support.dbaccess.service;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.github.support.dbaccess.dto.ScheduleJob;
import com.github.support.utils.json.GsonUtil;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring-test.xml" })
public class ScheduleJobServiceTest {

	@Autowired
	private ScheduleJobServiceDb service;

	@Test
	public void testGetList() {
		List<ScheduleJob> tt = service.getList(2, 10);

		System.err.println(tt.size());
		String json = JSON.toJSONString(tt);
		System.err.println(json);

		String json2 = GsonUtil.gsonString(tt);
		System.err.println(json2);
	}

}
