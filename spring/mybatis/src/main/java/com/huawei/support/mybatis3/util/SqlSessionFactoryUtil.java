package com.huawei.support.mybatis3.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactoryUtil
{
	private static SqlSessionFactory sqlSessionFactory;

	public static SqlSessionFactory getSqlSession() throws IOException
	{
		if (sqlSessionFactory == null)
		{
			InputStream inpt = null;
			inpt = Resources.getResourceAsStream("mybatis-config.sqllite.xml");
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(inpt);
		}
		return sqlSessionFactory;
	}
	public static SqlSession OpenSession() throws IOException
	{
		return getSqlSession().openSession();

	}
}
