package com.github.support.cbb.utils;

import java.util.Date;
import com.sun.xml.bind.v2.runtime.RuntimeUtil.ToStringAdapter;

public abstract class DateUtil
{
	final static String yyyy_MM_dd_HH_mm_ss = "yyyy_MM_dd_HH_mm_ss";
	
	static String ToStringAdapter(Date dt)
	{
		return yyyy_MM_dd_HH_mm_ss;
	}
	
	
}
