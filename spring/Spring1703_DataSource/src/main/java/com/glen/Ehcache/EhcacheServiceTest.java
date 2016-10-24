package com.glen.Ehcache;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Resource;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import com.glen.service.AccountService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring.xml")
public class EhcacheServiceTest
{
	@Autowired
	ApplicationContext ctx;

	@Autowired
	EhcacheService ehcache;

	@Test
	public void test()
	{
		CacheManager cacheManager = CacheManager.newInstance("D:/Workspaces/MyEclipsePro2013/Spring1703_DataSource/src/main/resources/ehcache.xml");
		// 获取ehcache配置文件中的一个
		Cache cache = cacheManager.getCache("sample");
		assertNotNull(cache);
	}

	@Test
	public void testGetCache()
	{
		ehcache.getCache();
		Cache cache = ehcache.getCache();
		assertNotNull(cache);
	}
	
	@Test
	public void testPut()
	{
		String key1 ="key1"; 
		
		SysConfig config1 = new SysConfig(key1,"value2");
		
		List<SysConfig> cfgs = new ArrayList<SysConfig>();
		List<String > keys = new   ArrayList<String>();
		for (int  i =1000 ; i<10000; i++)
		{String key ="key"+i; 
			keys.add(key);
			cfgs.add(new SysConfig(key,"value"+ i));
		}
	
		ehcache.put(config1 );
		ehcache.get(key1 );
		assertEquals(config1, ehcache.get(key1 ));
		
	}

}
