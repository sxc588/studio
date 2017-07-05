package com.github.support.dsdp.config;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DSDPConfigService
{
	private static Logger Logger = LoggerFactory.getLogger(DSDPConfigService.class);

	private static List<DSDPConfig> configsDB = new ArrayList<DSDPConfig>();

	public static String getConfigValue(String key)
	{
		for (DSDPConfig config : configsDB)
		{
			if (config.getKey().equals(key))
				return config.getValue();
		}
		return StringUtils.EMPTY;
	}
	
	public static DSDPConfig getConfig(String key)
	{
		for (DSDPConfig config : configsDB)
		{
			if (config.getKey().equals(key))
				return config;
		}
		return null;
	}
	
	
	public static List<DSDPConfig> getConfigsByParent(String parent)
	{
		List<DSDPConfig> configs = new ArrayList<DSDPConfig>();
		for (DSDPConfig config : configsDB)
		{
			if (config.getParent().equals(parent))
			{
				configs.add(config);
			}
		}
				return configs;

	}
	
	public static void putConfig(DSDPConfig conf)
	{
		configsDB.add(conf);
	}


}
