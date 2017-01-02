package com.github.support.cbb.migration.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface IMigrationHandler
{
	public abstract class HandlerUtils
	{

		
		
		private static final int ONE_PAGE_SIZE = 200;

		public static Map<String, Object> getPageParm(Date beginTime, Date endTime, int pageIndex)
		{
			Map<String, Object> pagePam = getPageParm(pageIndex);
			pagePam.put("beginTime", beginTime);
			pagePam.put("endTime", endTime);
			return pagePam;
		}

		public static Map<String, Object> getPageParm(int indexPage)
		{
			int begin = indexPage * ONE_PAGE_SIZE;
			int end = (indexPage + 1) * ONE_PAGE_SIZE;

			Map<String, Object> pagePam = new HashMap<String, Object>();
			pagePam.put("begin", begin);
			pagePam.put("end", end);
			return pagePam;
		}

		public static Map<String, Object> getPageParm(int pageIndex, String fromFlag)
		{
			Map<String, Object> pagePam = getPageParm(pageIndex);
			pagePam.put("fromFlag", fromFlag);
			return pagePam;
		}
	}

	int migrationAll();

	int migrationInc(Date beginTime, Date endTime);

	int migrationDel();
}
