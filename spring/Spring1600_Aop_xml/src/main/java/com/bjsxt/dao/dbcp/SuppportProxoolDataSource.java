package com.bjsxt.dao.dbcp;

import org.logicalcobwebs.proxool.ProxoolDataSource;

/**
 * 定制ProxoolDataSource 类，对密码解密
 * 
 * @author Administrator
 *
 */
public class SuppportProxoolDataSource extends ProxoolDataSource
{
	@Override
	public final void setPassword(final String password)
	{

		String decPassword = password;
		super.setPassword(decPassword);
	}
}

// spring 常用的 连接池 : dbcp