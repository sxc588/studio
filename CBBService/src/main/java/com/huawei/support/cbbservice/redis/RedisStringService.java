/**  
 * 实现对Java配置文件Properties的读取、写入与更新操作  
 */
package com.huawei.support.cbbservice.redis;

import redis.clients.jedis.Jedis;



/**
 *    * redis存储字符串
 * @author Administrator
 *
 */
public class RedisStringService
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
		
		
//		  //-----添加数据----------  
//		 30         jedis.set("name","xinxin");//向key-->name中放入了value-->xinxin  
//		 31         System.out.println(jedis.get("name"));//执行结果：xinxin  
//		 32         
//		 33         jedis.append("name", " is my lover"); //拼接
//		 34         System.out.println(jedis.get("name")); 
//		 35         
//		 36         jedis.del("name");  //删除某个键
//		 37         System.out.println(jedis.get("name"));
//		 38         //设置多个键值对
//		 39         jedis.mset("name","liuling","age","23","qq","476777XXX");
//		 40         jedis.incr("age"); //进行加1操作
//		 41         System.out.println(jedis.get("name") + "-" + jedis.get("age") + "-" + jedis.get("qq"));
//		 42     
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
