package com.glen.Ehcache;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.annotation.Resource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;


@Service(value="ehcacheService")
public class EhcacheService
{
	private Cache cache;

	public Cache getCache()
	{
		return cache;
	}
	
	public  EhcacheService()
	{
		CacheManager cacheManager = CacheManager.newInstance("D:/Workspaces/MyEclipsePro2013/Spring1703_DataSource/src/main/resources/ehcache.xml");
		// 获取ehcache配置文件中的一个
		this.cache = cacheManager.getCache("sample");
	}

	//@Resource(name="ehcache")  
	public void setCache(Cache cache)
	{
		this.cache = cache;
	}

	public void put(SysConfig config)
	{
		String key = config.getKey();
		Element element = new net.sf.ehcache.Element(key, config);
		this.cache.put(element);

	}

	public SysConfig get(String key)
	{
		Element element = this.cache.get(key);
		if (null == element)
		{
			return null;
		}
		if (element.getObjectValue() instanceof SysConfig)
		{
			return (SysConfig) element.getObjectValue();
		}
		return null;

	}
	public boolean remove(String key)
	{
		return this.cache.remove(key);
	}

	public void removeAll()
	{
		this.cache.removeAll();
	}

	public void removeAll(Collection<String> keys)
	{
		this.cache.removeAll(keys);
	}

	public void putAll(Collection<SysConfig> cfgs)
	{
		List<Element> elements = new ArrayList<Element>();
		for (SysConfig cfg : cfgs)
		{
			String key = cfg.getKey();
			Element element = new net.sf.ehcache.Element(key, cfg);
			elements.add(element);
		}
		this.cache.putAll(elements);
	}

	// //在代码中使用注解的方式进行缓存声明：
	// @Cacheable(value = "user", key = "'all'")
	// public List<SerializableJSONObject> listMessage () {
	// String sql = "select * from prc_mbl_msg";
	// System.out.printf("我在测试缓存！！！");
	// return this.baseDao.sqlQueryResult(sql, new Object[]{});
	// }
	//
	// // 清除缓存：
	//
	// @CacheEvict(value = "user", key = "'all'")
	// public void removeMessageCache () {
	// System.out.printf("我再去除测试！！！");
	// }

}
