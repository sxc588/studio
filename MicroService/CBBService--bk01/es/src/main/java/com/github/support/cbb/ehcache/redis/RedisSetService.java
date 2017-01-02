/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.github.support.cbb.ehcache.redis;

import redis.clients.jedis.Jedis;



/**
 *    * redis存储字符串
 * @author Administrator
 *
 */
public class RedisSetService
{
	
	 private Jedis jedis; 
	 
		public void Init() 
		{
	  //连接redis服务器，192.168.0.100:6379
    jedis = new Jedis("192.168.0.100", 6379);
	      //权限认证
	   jedis.auth("admin");  
	 
		}
	 
	
	public  String write(String key, String value) 
	{
		  return jedis.set(key,value);//向key-->name中放入了value-->xinxin  
		
		
///添加  
//105         jedis.sadd("user","liuling");  
//106         jedis.sadd("user","xinxin");  
//107         jedis.sadd("user","ling");  
//108         jedis.sadd("user","zhangxinxin");
//109         jedis.sadd("user","who");  
//110         //移除noname  
//111         jedis.srem("user","who");  
//112         System.out.println(jedis.smembers("user"));//获取所有加入的value  
//113         System.out.println(jedis.sismember("user", "who"));//判断 who 是否是user集合的元素  
//114         System.out.println(jedis.srandmember("user"));  
//115         System.out.println(jedis.scard("user"));//返回集合的元素个数  
//		
	}
	public  String get(String key)
	{
		  return jedis.get(key);//向key-->name中放入了value-->xinxin  
	}
	public  Long delete(String key)
	{
		  return jedis.del(key);//向key-->name中放入了value-->xinxin  
	}
	
	
//	public  void mset(String key)
//	{
//		  return jedis.mset(key);//向key-->name中放入了value-->xinxin  
//	}
	
}
