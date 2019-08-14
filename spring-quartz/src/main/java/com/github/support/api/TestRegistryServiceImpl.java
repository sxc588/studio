package com.github.support.api;

import org.springframework.stereotype.Service;

@Service("testRegistryService") 
public class TestRegistryServiceImpl implements TestRegistryService {

	@Override
	public String hello(String name) {
		return "hello"+name; 
	}

}
