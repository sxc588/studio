package com.huawei.support.mybatis3.util;

import org.apache.commons.lang3.StringUtils;

public class DataSourceConfigs
{
	private static final double OneGB = Math.pow(2, 30);
	private static final int OneGBQuryTimes = 30;

	public String getValue(String key)
	{
		return StringUtils.EMPTY;
	}
	
	public int getValueCnt(long totalSize)
	{
		return (int)Math.ceil(totalSize/ OneGB) *OneGBQuryTimes;
	}
}
