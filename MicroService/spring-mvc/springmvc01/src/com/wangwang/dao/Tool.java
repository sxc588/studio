package com.wangwang.dao;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class Tool {
	/**
	 * 日期转字符串
	 * @param df.format(date) 
	 * @return strDate
	 */
	public static String conventDateToString(Date date){
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		String strDate = df.format(date);
		return strDate;
	}
	 /**
	  * 字符串转日期
	  * @param df.parse(strDate)
	  * @return date
	  * @throws ParseException
	  */
	public static Date conventStringToDate(String strDate) throws ParseException{
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
		Date date = df.parse(strDate);
		return date;
	}
}
