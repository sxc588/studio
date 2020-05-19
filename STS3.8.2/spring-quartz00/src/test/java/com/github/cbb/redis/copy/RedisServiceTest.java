package com.github.cbb.redis.copy;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.support.service.redis.RedisService;

@RunWith(SpringJUnit4ClassRunner.class) // 使用junit4进行测试
@ContextConfiguration(locations = { "classpath:spring/spring-redis.xml" }) // 加载配置文件
public class RedisServiceTest
{

	@Autowired
	private RedisService service;

	@Test
	public void testExpire()
	{
		service.set("DDD", "DDDDDDDDDDD");
		String kbString = (String) service.get("DDD");

		System.out.println(kbString);
	}

	@Test
	public void testincr()
	{

		for (int i = 0; i < 2; i++)
		{
			long kbString = service.incr("DD2D", 1);

			System.out.println(kbString);
		}
		service.expire("DD2D", 1);
		long d = service.getExpire("DD2D");
		System.err.println(d);
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
