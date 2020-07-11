package com.github.support.clients.redis;


/**
 * 4）对value操作的命令
 *
 */
public interface RedisCli {

	
	/**
	 * 确认一个key是否存在；
	 * @param log
	 * @param descrption
	 * @param e
	 */
	 void exists(String key);

	/**
	 * 删除一个key;
	 */
	 void  del(String key);

	/**
	 * 返回值的类型
	 */
	 void  type(String key);

	
	/**
	 * 返回满足给定pattern的所有key
	 */
	 void keys(String pattern);

	/**
	 * 随机返回key空间的一个
	 */
	 void randomkey();

	/**
	 * 重命名key
	 */
	 void keyrename(String oldname, String newname);

	
	
	/**
	 * 返回当前数据库中key的数目
	 */
	 void dbsize();

	/**
	 * 设定一个key的活动时间（s）
	 */
	 void expire();

	/**
	 * 获得一个key的活动时间
	 */
	 void ttl();

	/**
	 * 按索引查询
	 */
	 void select(String index);

	/**
	 * 移动当前数据库中的key到dbindex数据库
	 */
	 void move(String key, String dbindex);

	/**
	 * 删除当前选择数据库中的所有key
	 */
	 void flushdb();

	/**
	 * 删除所有数据库中的所有key
	 */
	 void flushall();
	
}
