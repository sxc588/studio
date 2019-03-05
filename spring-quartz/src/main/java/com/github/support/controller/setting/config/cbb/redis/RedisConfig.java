package com.github.support.controller.setting.config.cbb.redis;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import com.alibaba.fastjson.JSON;
import com.github.support.controller.setting.config.cbb.net.IpUtil;
import com.github.support.dbaccess.dto.ConfigDto;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Redis--利用JAVA操作Redis Time: 2012.5.7 16:23:15
 */
@Service
public class RedisConfig
{
	JedisPool pool;
	Jedis jedis;

	final String key = "Config";

	public RedisConfig()
	{
		pool = new JedisPool(new JedisPoolConfig(), "192.168.1.72");
		jedis = pool.getResource();
		// jedis.auth("password");

		addShutdownHook();
	}

	private void addShutdownHook()
	{
		Thread shutdownThead = new Thread()
		{
			public void run()
			{
				IOUtils.closeQuietly(jedis);
				System.out.println("Redis Shutdown Hook...");
			}
		};
		Runtime.getRuntime().addShutdownHook(shutdownThead);
	}

	public long del(String... fields)
	{
		return jedis.hdel(key, fields);
	}

	public String flushDB()
	{
		return jedis.flushDB();
	}

	public ConfigDto get(String field)
	{
		String json = jedis.hget(key, field);

		ConfigDto dto = StringUtils.isNotBlank(json) ? JSON.parseObject(json, ConfigDto.class) : null;
		return dto;
	}

	public List<ConfigDto> getAll()
	{
		Map<String, String> stringMap = jedis.hgetAll(key);

		List<ConfigDto> dtos = new ArrayList<ConfigDto>();

		for (Entry<String, String> entry : stringMap.entrySet())
		{

			String json = entry.getValue();
			System.out.println(json);

			ConfigDto dto = StringUtils.isNotBlank(json) ? JSON.parseObject(json, ConfigDto.class) : null;
			dtos.add(dto);
		}

		return dtos;

	}

	public Long put(ConfigDto dto)
	{

		String field = dto.getKey();
		String value = JSON.toJSONString(dto);
		return jedis.hset(key, field, value);
	}

	/**
	 * Redis存储初级的字符串 CRUD
	 */
	// @Test
	public void testBasicString()
	{
		ConfigDto dto = new ConfigDto();

		flushDB();

		dto.setKey("key1");
		dto.setValue("value1");
		dto.setLastUpdateTime(new Date());
		dto.setLastUpdateBy(IpUtil.getIpAddr());

		put(dto);
		ConfigDto abc = get("key1");
		// System.out.println(JSON.toJSON(abc));// 返回的sname [sname, name]

		dto.setKey("key2");
		dto.setValue("value2");

		put(dto);
		List<ConfigDto> all = getAll();
		System.out.println(JSON.toJSONString(all));// 返回的sname [sname, name]

	}
}