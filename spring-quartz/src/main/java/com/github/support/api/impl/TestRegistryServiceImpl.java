package com.github.support.api.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.github.support.api.TestRegistryService;

@RequestMapping(value = "/dubbo")
@Service("testRegistryService")
public class TestRegistryServiceImpl implements TestRegistryService {

	@RequestMapping(value = "hello", method = RequestMethod.GET)
	@Override
	public String hello(String name) {
		return "hello" + name;
	}

}
