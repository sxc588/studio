package com.github.support.clients.redis;

/**
 * 4）对value操作的命令
 * @author Administrator
 *
 */
public interface RedisCliSet {

	
	/**
	 * 向名称为key的set中添加元素member
	 */
	void sadd(String key, String member);

	/**
	 * 删除名称为key的set中的元素member
	 */
	void srem(String key,String  member);

	/**
	 * 随机返回并删除名称为key的set中一个元素
	 */
	void spop(String key);

	/**
	 * 移到集合元素
	 */
	void smove(String srckey,String  dstkey, String member);

	/**
	 * 返回名称为key的set的基数
	 */
	void scard(String key);

	/**
	 * member是否是名称为key的set的元素
	 */
	void sismember(String key,String  member);

	/**
	 * 求交集
	 */
	void sinter(String keyn);

	/**
	 * 求交集并将交集保存到dstkey的集合
	 */
	void sinterstore(String dstkey, String keys);

	/**
	 * 求并集
	 */
	void sunion(String  key1, String  keys);

	/**
	 * 求并集并将并集保存到dstkey的集合
	 */
	void sunionstore(String  dstkey, String keys);

	/**
	 * 求差集
	 */
	void sdiff(String key1, String keys);

	/**
	 * 求差集并将差集保存到dstkey的集合
	 */
	void sdiffstore(String dstkey, String keys);

	/**
	 * 返回名称为key的set的所有元素
	 */
	void smembers(String key);

	/**
	 * 随机返回名称为key的set的一个元素
	 */
	void srandmember(String key);

}
