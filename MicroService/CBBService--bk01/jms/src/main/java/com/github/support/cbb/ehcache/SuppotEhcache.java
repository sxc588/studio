package com.github.support.cbb.ehcache;

import java.util.HashMap;
import java.util.Map;
import org.springframework.cache.Cache;
import org.springframework.cache.ehcache.EhCacheCache;
import com.github.support.cbb.ehcache.jms.JMSMessageService;
import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

public class SuppotEhcache  extends EhCacheCache implements Cache 
{

	
	JMSMessageService jmsSender;
	
	public SuppotEhcache(Ehcache ehcache)
	{
		super(ehcache);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void put(Object key, Object value)
	{
		this.getNativeCache().put(new Element(key,value));
		
		Map<String, Object> cacheEvent  = new HashMap<String, Object>();
		
		cacheEvent.put("cacheName", this.getName());
		cacheEvent.put("key", key);
		cacheEvent.put("value", value);
		jmsSender.sendMessage(cacheEvent);
		
	}

	public boolean Remove(Object key)
	{
	
		
	    Map<String, Object> cacheEvent  = new HashMap<String, Object>();
		
		cacheEvent.put("cacheName", this.getName());
		cacheEvent.put("key", key);
		cacheEvent.put("value", "");
		jmsSender.sendMessage(cacheEvent);
		
		return this.getNativeCache().remove(key);
		
		
	}

	@Override
	public void clear()
	{
		this.getNativeCache().removeAll();
	}
}
