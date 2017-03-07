package com.github.support.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import org.apache.commons.dbutils.DbUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import com.github.support.cbb.utils.CodexCC;
public class DynamicQuery
{

	private static Logger logger = LoggerFactory.getLogger(DynamicQuery.class);

	public static void main(String[] args) throws SQLException
	{
		for (int i = 0; i < 1; i++)
		{
			// 数据库的连接驱动，一般是不需要变的
			String DRIVER = "com.mysql.jdbc.Driver";
			// 数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
			String URL = "jdbc:mysql://localhost:3306/test";
			// 登录账户
			String DBNAME = "root";
			// 登录的密码
			String DBPASS = "root";
			String sql = "select *  from t_account where 1=1";
			
			ArrayList<HashMap<String, String>> result = executeQuery(DRIVER, URL, DBNAME, DBPASS, sql);
			
			System.out.println(result);
		}
	}
	
	public static ArrayList<HashMap<String, String>> executeQuery(
															final String driver,
															final String URL,
															final String username,
															final String password,
															final String sql)
	{
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet resultSet = null;
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(URL, username, password);
			logger.info(String.format("获取数据库连接成功!URL【%s】;username【%s】;password【%s】.", URL, username, password));

			psm = con.prepareStatement(sql);
			resultSet = psm.executeQuery();
			logger.info(String.format("执行SQL成功!【%s】.", sql));
	
			// 获取所有的列名
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
			{
				logger.info(resultSetMetaData.getColumnName(i + 1));
			}
			
			// 遍历结果集
			ArrayList<HashMap<String, String>> resultList = new ArrayList<HashMap<String, String>>();
			while (resultSet.next())
			{
				HashMap<String, String> rowMap = new HashMap<String, String>();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
				{
					String column = resultSetMetaData.getColumnName(i + 1);
					String value = resultSet.getString(column);

					rowMap.put(column, value);
				}
				resultList.add(rowMap);
			}
			logger.info(String.format("遍历结果集完成! Rows【%d】", resultList.size()));
			
			System.out.println(resultList);
			return resultList;
		}
		catch (Exception e)
		{
			//e.printStackTrace();
			CodexCC.report(logger, "发生Exception", e);
		}
		finally
		{

			if (resultSet != null)
			{
				DbUtils.closeQuietly(resultSet);
				logger.info(String.format("关闭结果集成功!"));
			}
			if (psm != null)
			{
				DbUtils.closeQuietly(psm);
				logger.info(String.format("关闭结果查询语句成功！"));
			}
			if (con != null)
			{
				DbUtils.closeQuietly(con);
				logger.info(String.format("关闭连接成功！"));
			}
		}

		return null;
	}
}