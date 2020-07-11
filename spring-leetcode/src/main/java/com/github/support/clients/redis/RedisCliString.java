package com.github.support.clients.redis;

/**
 * 4）对value操作的命令
 * @author Administrator
 *
 */
public interface RedisCliString {

	
	/**
	 * 给数据库中名称为key的string赋予值value
	 */
	void set(String key, String value);

	/**
	 * 返回数据库中名称为key的string的value
	 */
	void get(String key);

	/**
	 * 给名称为key的string赋予上一次的value
	 */
	void getset(String key, String value);

	/**
	 * 返回库中多个string的value
	 */
	void mget(String ...keyn);

	/**
	 * ：添加string，名称为key，值为value
	 */
	void setnx(String key, String value);

	/**
	 * 向库中添加string，设定过期时间time
	 */
	void setex(String key, String time, String value);

	/**
	 * 批量设置多个string的值
	 */
	void mset(String keyN, String valueN);

	/**
	 * 如果所有名称为key i的string都不存在
	 */
	void msetnx(String keyN, String  valueN);

	/**
	 * 名称为key的string增1操作
	 */
	void incr(String key);

	/**
	 * 名称为key的string增加integer
	 */
	void incrby(String key, String integer);

	/**
	 * 名称为key的string减1操作
	 */
	void decr(String key);

	/**
	 * 名称为key的string减少integer
	 */
	void decrby(String key, String integer);

	/**
	 * 名称为key的string的值附加value
	 */
	void append(String key, String value);

	/**
	 * 返回名称为key的string的value的子串
	 */
	void substr(String key, String start, String end);
	
}
