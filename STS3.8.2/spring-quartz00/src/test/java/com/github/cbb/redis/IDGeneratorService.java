package com.github.cbb.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.support.service.redis.RedisService;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-redis.xml" }) // 加载配置文件
public class IDGeneratorService
{

	@Autowired
	private RedisService service;

	@Test
	public void testGenId()
	{
		genId("DDDD");
		genId("DDDD", 300);
	}

	public long genId(String key)
	{
		long kbString = service.incr(key, 1);

		System.out.println(kbString);
		return kbString;
	}

	public long genId(String key, int delt)
	{
		long kbString = service.incr(key, delt);
		System.out.println(kbString);

		return kbString;
	}

	public void setId(String key, long initVal)
	{
		boolean kbString = service.set(key, initVal);
		System.out.println(kbString);
	}

	@Test
	public void testGet()
	{

		for (int i = 0; i < 2; i++)
		{
			long kbString = (long) service.get("DD2D");

			System.out.println(kbString);
		}
		service.expire("DD2D", 1);
		long d = service.getExpire("DD2D");
		System.err.println(d);
	}
}
