package com.huawei.cache;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;

/**
 * 
 * Ehcace 使用帮助类
 * @author Administrator
 *
 */
public class CancheUtil
{
	static Logger logger = LoggerFactory.getLogger(CancheUtil.class);
	static Cache cache=null;
	static {
		ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		Resource resource = resolver.getResource("ehcache-config.xml");
		
		InputStream is = null;
		try
		{
			is = resource.getInputStream();
		} catch (IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		CacheManager manager = CacheManager.create(is);
		cache = manager.getCache("sysconfig");
	}
	
	public static void putConfig(String key ,String value)
	{
		if (null == cache )
		{
			return;
		}
		logger.info("将数据保存到缓存.key= " + key);
		
		CancheUtil.cache.put(new Element(key, value));
	}
	
	public static String getConfig(String key)
	{
		if (null == cache )
		{
			return StringUtils.EMPTY;
		}
		
		Object obj = CancheUtil.cache.get(key);
		if (obj instanceof String )
		{
			logger.info("从数据中读取缓存.key= " + key);
			return (String) obj;
		}
		return StringUtils.EMPTY;
	}
	public static boolean delConfig(String key)
	{
		if (null == cache )
		{
			return false;
		}
		
		logger.info("删除缓存.key= " + key);
		return CancheUtil.cache.remove(key);
	}

	
}
