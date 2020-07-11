package com.github.support.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

/*
 * yyyy：年
 * MM：月
 * dd：日
 * hh：1~12小时制(1-12)
 * HH：24小时制(0-23)
 * mm：分
 * ss：秒
 * S：毫秒
 * E：星期几
 * D：一年中的第几天
 * F：一月中的第几个星期(会把这个月总共过的天数除以7)
 * w：一年中的第几个星期
 * W：一月中的第几星期(会根据实际情况来算)
 * a：上下午标识
 * k：和HH差不多，表示一天24小时制(1-24)。
 * K：和hh差不多，表示一天12小时制(0-11)。
 * z：表示时区 
 * 
 * yyyy-MM-dd HH:mm:ss
 *  
 */
public class DataUtail {

	@Test
	public void calendarTest() {

		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

		Date t1 = new Date();
		Calendar cal = Calendar.getInstance();
		cal.setTime(t1);

		cal.set(Calendar.DAY_OF_MONTH, 1);
		System.out.println(sdf.format(cal.getTime()));

		cal.add(Calendar.DAY_OF_MONTH, -1);
		System.out.println(sdf.format(cal.getTime()));

		cal.add(Calendar.MONTH, -12);
		System.out.println(sdf.format(cal.getTime()));

	}

	@Test
	public void formatDataTest() {
		/*
		 * 日期转期望格式的字符串
		 */
		// HH 和 hh 的差别：前者是24小时制，后者是12小时制。
		StringBuilder sb = new StringBuilder();
		sb.append("yyyy年MM月dd日 HH:mm:ss").append(" 上下午标志:a").append(" E").append(" 一年中的第D天").append(" 一月中的第F个星期")
				.append(" 一年中的第w个星期").append(" 一月中的第W个星期").append(" Z").append(" z");
		SimpleDateFormat sdf = new SimpleDateFormat(sb.toString());
		String dateString = sdf.format(new Date());
		System.out.println(dateString);

		/*
		 * 字符串转日期
		 */
		Date date;
		try {
			date = sdf.parse(dateString);
			System.out.println(date);
		} catch (ParseException e) {
			System.out.println(e.getMessage());
		}
	}

}
