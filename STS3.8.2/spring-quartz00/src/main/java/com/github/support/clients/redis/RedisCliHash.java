package com.github.support.clients.redis;

/**
 * 4）对value操作的命令
 * @author Administrator
 *
 */
public interface RedisCliHash {

	
	
	/**
	 * ：向名称为key的hash中添加元素field
	 */
	void hset(String key, String field, String value);

	/**
	 * ：返回名称为key的hash中field对应的value
	 */
	void hget(String key,String field);

	/**
	 * ：返回名称为key的hash中field i对应的value
	 */
	void hmget(String key, String fields);

	/**
	 * ：向名称为key的hash中添加元素field
	 */
	void hmset(String key, String fields);

	/**
	 * ：将名称为key的hash中field的value增加integer
	 */
	void hincrby(String key, String  field, int integer);

	/**
	 * ：名称为key的hash中是否存在键为field的域
	 */
	void hexists(String key, String field);

	/**
	 * ：删除名称为key的hash中键为field的域
	 */
	void hdel(String key, String field);

	/**
	 * ：返回名称为key的hash中元素个数
	 */
	void hlen(String key);

	/**
	 * ：返回名称为key的hash中所有键
	 */
	void hkeys(String key);

	/**
	 * ：返回名称为key的hash中所有键对应的value
	 */
	void hvals(String key);

	/**
	 * ：返回名称为key的hash中所有的键（field）及其对应的value
	 */
	void hgetall(String key);
}
