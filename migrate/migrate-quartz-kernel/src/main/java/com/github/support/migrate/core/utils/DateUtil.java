package com.github.support.migrate.core.utils;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil
{
	// 注意format的格式要与日期String的格式相匹配
	private static DateFormat sdf = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
	
	public String toDate(Date date)
	{
		return sdf.format(date);
	}
	
	public Date toDate(String date)
	{
		try
		{
			return sdf.parse(date);
		}
		catch (ParseException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
