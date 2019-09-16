package com.github.support.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

@Service
public class PerformancMatrixBean {
	private static final DateFormat bf = new SimpleDateFormat("yyyy-MM-ddHHmm");

	Map<String, Integer> performMatrix = new HashMap<String, Integer>();

	public Map<String, Integer> getPerformMatrix() {
		return performMatrix;
	}

	public void inc() {
		Date date = new Date();// 创建时间
		String key = bf.format(date);// 格式化 bf.format(date);

		if (performMatrix.containsKey(key)) {
			int value = performMatrix.get(key);
			performMatrix.put(key, value);
		} else {
			performMatrix.put(key, 1);
		}
	}

}
