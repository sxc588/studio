package com.github.support.ccb.redis;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import redis.clients.jedis.JedisShardInfo;
import redis.clients.jedis.ShardedJedis;
import redis.clients.jedis.ShardedJedisPool;
import redis.clients.jedis.SortingParams;
import redis.clients.jedis.util.IOUtils;



public class RedisClient {

    private Jedis jedis;//非切片额客户端连接
    private JedisPool jedisPool;//非切片连接池
    private ShardedJedis shardedJedis;//切片额客户端连接
    private ShardedJedisPool shardedJedisPool;//切片连接池
    
    public RedisClient() 
    { 
        initialPool(); 
        initialShardedPool(); 
        shardedJedis = shardedJedisPool.getResource(); 
        jedis = jedisPool.getResource(); 
    } 
 
    /**
     * 初始化非切片池
     */
    private void initialPool() 
    { 
        // 池基本配置 
        JedisPoolConfig config = new JedisPoolConfig(); 
        
        //config.setMaxActive(20); 
        config.setMaxIdle(5); 
        //config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        
        jedisPool = new JedisPool(config,"192.168.1.72",6379);
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
        //config.setMaxWait(1000l); 
        config.setTestOnBorrow(false); 
        // slave链接 
        List<JedisShardInfo> shards = new ArrayList<JedisShardInfo>(); 
        shards.add(new JedisShardInfo("192.168.1.72", 6379, "master")); 

        // 构造池 
        shardedJedisPool = new ShardedJedisPool(config, shards); 
    } 

    public void show() {     
        KeyOperate(); 
        StringOperate(); 
        ListOperate(); 
        SetOperate();
        SortedSetOperate();
        HashOperate(); 
        //jedisPool.returnResource(jedis);
       // shardedJedisPool.returnResource(shardedJedis);
    } 

    @Test
      public void KeyOperate() {
         
    	  
    	Jedis jedis=new Jedis("192.168.1.72",6379);//连接的是我本地的服务
  		System.out.println("成功连接到服务器==");
  		
  		/*存取string类型*/
  		jedis.set("name", "lhc");
  		System.out.println(jedis.get("name"));
  		
  		/*存取hash类型*/
  		jedis.hset("hash", "k1", "v1");
  		jedis.hset("hash", "k2", "v2");
  		jedis.hset("hash", "k3", "v3");
  		jedis.hdel("hash", "k3");
  		System.out.println(jedis.hvals("hash"));
  		
  	    /*存取list*/
  		jedis.lpush("student", "lhc");
  		jedis.lpush("student", "水田如雅");
  		jedis.lpush("student", "杰伦哥哥");
  		List<String> stuList=jedis.lrange("student", 0, 2);
  		System.out.println(JSON.toJSON(stuList));
  		//model.addAttribute("stuList",stuList.toString());
  		
  		/*存取set*/
  		jedis.sadd("person","lhc");
  		jedis.sadd("person","水田");
  		jedis.sadd("person","小白");
  		System.out.println(JSON.toJSON(jedis.smembers("person")));

  		
  		/*存取zset*/
  		jedis.zadd("animal", 0, "cat");
  		jedis.zadd("animal", 0, "dog");
  		jedis.zadd("animal", 0, "sheep");
  		
  		System.out.println(JSON.toJSON(jedis.zrange("animal", 0, 2)));
  		
  		//查看服务是否允许
  		System.out.println("服务器正在连通中。。。状态："+jedis.ping());

  		if(jedis != null){
  			jedis.close();
		}  		
      }

      private void StringOperate() {
         
      }

      private void ListOperate() {
         
      }

      private void SetOperate() {
         
      }

      private void SortedSetOperate() {
         
      }
    
      private void HashOperate() {
         
      }
}