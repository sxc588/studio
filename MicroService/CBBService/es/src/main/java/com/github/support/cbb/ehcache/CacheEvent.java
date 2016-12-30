package com.github.support.cbb.ehcache;

public interface CacheEvent
{
	
	static final int PUT = 1;
	static final int UPDATE = 2;
	static final int REMOVE = 3;
	static final int EXPTRE = 4;
}
