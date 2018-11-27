package com.github.support.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.ws.rs.GET;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.support.dbaccess.service.MonMatrixService;

import javassist.expr.NewArray;

@Service
public class PerformancMatrixBean
{
	Map<String, Integer> performMatrix =  new HashMap<String, Integer>();

	private static final DateFormat bf = new SimpleDateFormat("yyyy-MM-ddHHmm");
	


	public void inc()
	{
		Date date = new Date();// 创建时间
		String key = bf.format(date);// 格式化 bf.format(date);

		if (performMatrix.containsKey(key))
		{
			int value = performMatrix.get(key);
			performMatrix.put(key, value);
		} else
		{
			performMatrix.put(key, 1);
		}
	}
	
	public Map<String, Integer> getPerformMatrix()
	{
		return performMatrix;
	}
	
	
}
