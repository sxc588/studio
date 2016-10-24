package com.bjsxt.helper;

import java.io.IOException;
import java.io.InputStream;
import java.util.Collection;
import java.util.LinkedHashSet;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import com.bjsxt.model.User;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * EhcaheHelper;
 * 
 * @author Administrator
 *
 */
public class EhcaheHelper
{
	private Cache cache;

	private Log LOG = LogFactory.getLog(EhcaheHelper.class);

	public EhcaheHelper() throws IOException
	{
			cache = Init();	
	}
	
	
	public Cache Init() throws IOException
	{
		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource resource = resourcePatternResolver.getResource("ehcache-cofig.xml");
		InputStream is = null;
		is = resource.getInputStream();

		CacheManager manager = CacheManager.create(is);

		Cache cache = manager.getCache("SystemConfigCache");

		return cache;
	}

	protected Cache loadCache(Resource resource)
	{

		try
		{
			InputStream is = resource.getInputStream();
			CacheManager manager = CacheManager.create(is);

			Cache cache = manager.getCache("SystemConfigCache");

			return cache;
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;

	}

	protected Collection<? extends Cache> loadCaches() throws IOException
	{
		Collection<Cache> caches = new LinkedHashSet<Cache>();

		ResourcePatternResolver resourcePatternResolver = new PathMatchingResourcePatternResolver();
		Resource[] resources = resourcePatternResolver.getResources("classpath*:ehcache*.xml");
		for (Resource resource : resources)
		{
			Cache cache = loadCache(resource);
			if (null != cache)
			{
				caches.add(cache);
			}
		}
		return caches;
	}

	public void put(String key, String value)
	{
		if (null == cache)
		{
			LOG.error("缓存对象为空，缓存数据失败！ key=" + key);
			return;
		}

		this.cache.put(new Element(key, value));
		LOG.error("缓存数据成功！- key=" + key);
	}

	public User get(String key)
	{
		if (null == cache)
		{
			LOG.error("缓存对象为空，无法从缓存中读取数据！ key=" + key);
			return null;
		}

		Element element = this.cache.get(key);
		if (null != element)
		{
			Object obj = element.getObjectValue();
			if (obj instanceof User)
			{
				return (User) obj;
			}
		}
		LOG.error("缓存数据成功！- key=" + key);

		return null;
	}
	
    public void remove(String key) {  
        this.cache.remove(key);  
    }  
}
