package com.github.support.cbb.ehcache;

import java.util.Collection;
import java.util.Map;
import org.springframework.cache.Cache;
import org.springframework.cache.support.AbstractCacheManager;

public class SupportEhCacheManager extends AbstractCacheManager
{
	Map<String, SuppotEhcache> caches;
	
	
	public SuppotEhcache getCache(String cacheName)
	{
		return caches.get(cacheName);
	}

	@Override
	protected Collection<? extends Cache> loadCaches()
	{
		// TODO Auto-generated method stub
		return null;
	}

}
