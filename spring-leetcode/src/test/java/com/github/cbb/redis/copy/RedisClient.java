package com.github.cbb.redis.copy;

import java.util.ArrayList;
import java.util.List;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;

public class RedisClient
{

	private Jedis jedis;// 非切片额客户端连接
	private JedisPool jedisPool;// 非切片连接池
	private ShardedJedis shardedJedis;// 切片额客户端连接
	private ShardedJedisPool shardedJedisPool;// 切片连接池

	public RedisClient()
	{
		initialPool();
		initialShardedPool();
		shardedJedis = shardedJedisPool.getResource();
		jedis = jedisPool.getResource();
	}

	private void HashOperate()
	{

	}

	/**
	 * 初始化非切片池
	 */
	private void initialPool()
	{
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();

		// config.setMaxActive(20);
		config.setMaxIdle(5);
		// config.setMaxWait(1000l);
		config.setTestOnBorrow(false);

		jedisPool = new JedisPool(config, "192.168.208.128", 6379);
	}

	/**
	 * 初始化切片池
	 */
	private void initialShardedPool()
	{
		// 池基本配置
		JedisPoolConfig config = new JedisPoolConfig();
		// config.setMaxActive(20);
		config.setMaxIdle(5);
		// config.setMaxWait(1000l);
		config.setTestOnBorrow(false);
		// slave链接
		List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>();
		shards.add(new JedisShardInfo("192.168.208.128", 6379, "master"));

		// 构造池
		shardedJedisPool = new ShardedJedisPool(config, shards);
	}

	private void KeyOperate()
	{

	}

	private void ListOperate()
	{

	}

	private void SetOperate()
	{

	}

	public void show()
	{
		KeyOperate();
		StringOperate();
		ListOperate();
		SetOperate();
		SortedSetOperate();
		HashOperate();
		// jedisPool.returnResource(jedis);
		// shardedJedisPool.returnResource(shardedJedis);
	}

	private void SortedSetOperate()
	{

	}

	private void StringOperate()
	{

	}
}