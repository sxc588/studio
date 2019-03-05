package com.github.support.utils;

import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import redis.clients.jedis.JedisCluster;


public class IDGenerateService
{
	@Autowired
	private JedisCluster jedisCluster;

	public String getJedisCluster(String key)
	{
		return jedisCluster.get(key);
	}

	public void setJedisCluster(String key,Long value)
	{
		jedisCluster.set(key, Long.toString(value));
	}

	@Transactional(propagation = Propagation.REQUIRES_NEW)
	public String nextId(String type)
	{
		Long nexId = jedisCluster.incr(type);
		return type + nexId;
	}
	
	@Transactional
	public List<String> nextId(String type, int count)
	{
		long nexId = jedisCluster.incrBy(type,count);
		
		List<String> resultList = new  ArrayList<String>(count);
		for (long i=nexId-count+1; i<=nexId; i++ )
		{
			resultList.add(type + i);
		}
		
		
		return resultList;
	}
}
