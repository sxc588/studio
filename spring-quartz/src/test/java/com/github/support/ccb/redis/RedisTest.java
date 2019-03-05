package com.github.support.ccb.redis;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;
import javax.sound.midi.Soundbank;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.*;

/**
 * 在Jedis开发中，我们很多时候希望直接把一个对象放到Redis中，然后在需要的时候取出来。Redis的key和value都支持二进制安全的字符串，存储Java对象不是问题，下面我们看一下如何来实现。
 */
public class RedisTest
{
	JedisPool pool;
	Jedis jedis;

	@Before
	public void setUp()
	{
		pool = new JedisPool(new JedisPoolConfig(), "192.168.1.72");
		jedis = pool.getResource();
		// jedis.auth("password");
	}

	public static class SerializeUtil
	{
		public static byte[] serialize(Object object)
		{
			ObjectOutputStream oos = null;
			ByteArrayOutputStream baos = null;
			try
			{
				// 序列化
				baos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(baos);
				oos.writeObject(object);
				byte[] bytes = baos.toByteArray();
				return bytes;
			}
			catch (Exception e)
			{

			}
			return null;
		}

		public static Object unserialize(byte[] bytes)
		{
			ByteArrayInputStream bais = null;
			try
			{
				// 反序列化
				bais = new ByteArrayInputStream(bytes);
				ObjectInputStream ois = new ObjectInputStream(bais);
				return ois.readObject();
			}
			catch (Exception e)
			{

			}
			return null;
		}
	}

	public class Person implements Serializable
	{
		/**
		 * 
		 */
		private static final long serialVersionUID = 1L;

		private int id;
		private String name;

		public Person(int id, String name)
		{
			this.id = id;
			this.name = name;
		}

		public int getId()
		{
			return id;
		}

		public String getName()
		{
			return name;
		}
	}

	/**
	 * Redis存储初级的字符串 CRUD
	 */
	@Test
	public void setObject()
	{
		Person person = new Person(100, "alan");
		jedis.set("person:100".getBytes(), SerializeUtil.serialize(person));
		person = new Person(101, "bruce");
		jedis.set("person:101".getBytes(), SerializeUtil.serialize(person));
	}

	public Person getObject(int id)
	{
		byte[] person = jedis.get(("person:" + id).getBytes());
		return (Person) SerializeUtil.unserialize(person);
	}

	@Test
	public void getObject()
	{

		Person person = this.getObject(100);
		System.out.println(person.getId());
		System.out.println(person.getName());
		person = this.getObject(101);
		System.out.println(person.getId());
		System.out.println(person.getName());
	}

}