package com.github.support.controller.setting.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.github.support.dbaccess.dto.ConfigDto;


@Repository
public class ConfigServcie
{
private List<ConfigDto> configs =  new ArrayList<ConfigDto>();
	
	
	public List<ConfigDto> list()
	{
		return configs;
	}

	public void save(ConfigDto configDto)
	{
		
		
		configDto.setLastUpdateTime(new Date());
		
	
    	configs.add(configDto);
		
	}

}
