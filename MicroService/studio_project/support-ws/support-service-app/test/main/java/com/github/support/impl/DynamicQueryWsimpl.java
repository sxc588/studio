package com.github.support.impl;

import java.util.ArrayList;
import java.util.HashMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.support.DynamicQueryWs;

public class DynamicQueryWsimpl implements DynamicQueryWs
{
	//private static Logger log= LoggerFactory.getLogger(DynamicQueryWsimpl.class);

	/**
	 * 
	 */
	@Override
	public ArrayList<HashMap<String, String>> executeQuery(
															String driver,
															String URL,
															String username,
															String password,
															String sql)
	{
		return DynamicQuery.executeQuery(driver, URL, username, password, sql);
	}

}
