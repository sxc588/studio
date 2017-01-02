package com.github.support.i18n.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import com.mybatis.mapper.I18nMapper;
import com.mybatis.model.I18n;

/**
 * 欢迎页面
 * 
 * @author 菠萝大象
 */
@Service
public class I18nBusiness
{
	Logger logger = LoggerFactory.getLogger(I18nBusiness.class);

	I18nMapper mapper;
	
	public void setMapper(I18nMapper mapper)
	{
		this.mapper = mapper;
	}

	public String getStringValue(String key)
	{
		logger.info("Enter HelloController.hello");

		return "hello";
	}
	
	public int  insert(I18n record)
	{
		return mapper.insert(record);
	}
}
