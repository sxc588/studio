package com.github.support;

import java.util.ArrayList;
import java.util.HashMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

public interface DynamicQueryWs
{

	@RequestMapping(value="xml", method=RequestMethod.GET)  
	ArrayList<HashMap<String, String>> executeQuery(
													final String driver,
													final String URL,
													final String username,
													final String password,
													final String sql);

}