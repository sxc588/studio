package com.github.support.cbb.migration.handler;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public interface IMigrationHandler
{
	enum FROM_Flag
	{
		 mysql_service(0),
		 supportv8_t_dsdp_user(101),
		supportv8_t_dsdp_userproperty(102),
		supportv8_t_dsdp_group(103),
		supportv8_t_dsdp_groupproperty(104),
		supportv8_t_dsdp_role(105),
		supportv8_t_dsdp_role2group(106),
		supportv8_t_dsdp_permission(107),
		supportv8_t_dsdp_entity2role(108),
		supportv8_t_dsdp_user2group(109),
		supportv8_t_dsdp_group2group(110),

		appsupporte_t_dsdp_user(201),
		appsupporte_t_dsdp_goup(202),
		appsupporte_t_dsdp_groupproperty(203),
		appsupporte_t_dsdp_groupleader(204),
		appsupporte_t_dsdp_role(205),
		appsupporte_t_dsdp_role2group(206),
		appsupporte_t_dsdp_rule(207),
		appsupporte_t_dsdp_entity2role(208),
		appsupporte_t_dsdp_group2enterprise(209);
		
		private int value = 0;
		
		public int getValue()
		{
			return this.value;
		}

		public void setValue(int value)
		{
			this.value = value;
		}

		private FROM_Flag(int value) {    //    必须是private的，否则编译错误
		        this.value = value;
		    };
	}

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

		public static Map<String, Object> getPageParm(Date beginTime, Date endTime,int pageIndex, FROM_Flag  fromFlag)
		{
			Map<String, Object> pagePam = getPageParm(beginTime,endTime,pageIndex);
			pagePam.put("fromFlag", fromFlag.getValue());
			return pagePam;
		}
		
		public static Map<String, Object> getPageParm(int pageIndex, FROM_Flag  fromFlag)
		{
			Map<String, Object> pagePam = getPageParm(pageIndex);
			pagePam.put("fromFlag", fromFlag.getValue());
			return pagePam;
		}
	}

	/**
	 * 全量迁移
	 */
	int migrationAll();

	int migrationInc(Date beginTime, Date endTime);

	/**
	 *  删除迁移
	 */
	int migrationDel();
	/**
	 *  删除迁移
	 */
	int migrationDelInc(Date beginTime, Date endTime);
}
