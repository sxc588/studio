package com.github.support.controller.setting.service;

import java.util.Collection;
import java.util.Date;
import java.util.Map;

import org.apache.commons.collections4.map.HashedMap;
import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.ConfigDto;

@Repository
public class ConfigServcie {
	private Map<String, ConfigDto> configs = new HashedMap<String, ConfigDto>();

	public ConfigDto get(String key) {
		return configs.get(key);
	}

	public Collection<ConfigDto> list() {
		return configs.values();
	}

	public void save(ConfigDto configDto) {
		configDto.setLastUpdateTime(new Date());
		configs.put(configDto.getKey(), configDto);
	}

}
