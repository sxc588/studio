package com.github.support.controller.setting.config;

import java.util.Collection;
import java.util.Date;
import java.util.Map;
import org.apache.commons.collections4.map.HashedMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.github.support.controller.setting.config.cbb.redis.RedisConfig;
import com.github.support.dbaccess.dto.ConfigDto;

@Repository
public class ConfigServcie
{

	@Autowired
	private RedisConfig redisConfig;

	private Map<String, ConfigDto> configs = new HashedMap<String, ConfigDto>();

	public Collection<ConfigDto> list()
	{

		return redisConfig.getAll();

		// return configs.values();
	}

	public void save(ConfigDto configDto)
	{
		configDto.setLastUpdateTime(new Date());
		// .put(configDto.getKey(), configDto);

		redisConfig.put(configDto);

	}

	public ConfigDto get(String key)
	{
		if (StringUtils.isBlank(key))
		{
			return null;
		}
		// return configs.get(key);
		return redisConfig.get(key);
	}
	
	

	public void get(String key)
	{
		if (StringUtils.isBlank(key))
		{
			return ;
		}
		// return configs.get(key);
		 redisConfig.del(key);
	}


}
