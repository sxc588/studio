package com.github.support.cbb.utils;

import java.util.Date;

public interface DateUtil
{
	final static String yyyy_MM_dd_HH_mm_ss = "yyyy_MM_dd_HH_mm_ss";
	
	static String ToStringAdapter(Date dt)
	{
		return yyyy_MM_dd_HH_mm_ss;
	}
	
}
