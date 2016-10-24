package com.huawei.support.commquery;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

//常用JDBC连接数据库方法总结如下：
//	一、JDBC连接DB2
//	Class.forName("Com.ibm.db2.jdbc.net.DB2Driver"); 
//	String url="jdbc:db2://dburl:port/DBname" 
//	cn = DriverManager.getConnection( url, sUsr, sPwd );
//
//	二、JDBC连接Microsoft SQLServer(microsoft)
//	Class.forName( "com.microsoft.jdbc.sqlserver.SQLServerDriver" ); 
//	cn = DriverManager.getConnection( "jdbc:microsoft:sqlserver://DBServerIP:1433;databaseName=master", sUsr, sPwd ); 
//
//	三、JDBC连接Sybase(jconn2.jar)
//	Class.forName( "com.sybase.jdbc2.jdbc.SybDriver" ); 
//	cn = DriverManager.getConnection( "jdbc:sybase:Tds:DBServerIP:2638", sUsr, sPwd ); 
//
//	四、JDBC连接MySQL(mm.mysql-3.0.2-bin.jar)
//	Class.forName( "org.gjt.mm.mysql.Driver" ); 
//	cn = DriverManager.getConnection( "jdbc:mysql://DBServerIP:3306/myDatabaseName", sUsr, sPwd ); 
//
//	五、JDBC连接PostgreSQL(pgjdbc2.jar)
//	Class.forName( "org.postgresql.Driver" ); 
//	cn = DriverManager.getConnection( "jdbc:postgresql://DBServerIP/myDatabaseName", sUsr, sPwd ); 
//
//	六、JDBC连接Oracle(classes12.jar)
//	Class.forName( "oracle.jdbc.driver.OracleDriver" ); 
//	cn = DriverManager.getConnection( "jdbc:oracle:thin:@MyDbComputerNameOrIP:1521:ORCL", sUsr, sPwd ); 
//
//	七、JDBC连接ODBC 
//	Class.forName( "sun.jdbc.odbc.JdbcOdbcDriver" ); 
//	Connection cn = DriverManager.getConnection( "jdbc:odbc:" + sDsn, sUsr, sPwd );

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
			String sql = "select count(*) as count  from account where 1=1";
			
			List<Map<String, String>> result = executeQuery(DRIVER, URL, DBNAME, DBPASS, sql);
			
			System.out.println(result);
		}
	}
	
	public static List<Map<String, String>> executeQuery(
															final String driver,
															final String URL,
															final String username,
															final String password,
															final String sql) throws SQLException
	{
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet resultSet = null;
		try
		{
			Class.forName(driver);
			con = DriverManager.getConnection(URL, username, password);
			logger.info(String.format("获取数据库连接成功!URL={};username=%s;password=%s.", URL, username, password));

			psm = con.prepareStatement(sql);
			resultSet = psm.executeQuery();
			logger.info(String.format("执行SQL成功!sql=%s.", sql));

			// 获取所有的列名
			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
			{
				logger.info(resultSetMetaData.getColumnName(i + 1));
			}

			logger.info(String.format("开始遍历结果集!size=%d.", resultSet.getFetchSize()));
			// 遍历结果集
			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			while (resultSet.next())
			{
				Map<String, String> rowMap = new HashMap<String, String>();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
				{
					String column = resultSetMetaData.getColumnName(i + 1);
					String value = resultSet.getString(column);

					rowMap.put(column, value);
				}
				resultList.add(rowMap);
			}
			return resultList;
		}
		catch (Exception e)
		{
			logger.info(String.format("发生Exception：.", e));
			e.printStackTrace();
		}
		finally
		{
			if (resultSet != null)
			{
				resultSet.close();
				logger.info(String.format("关闭结果集成功!"));
			}
			if (psm == null)
			{
				psm.close();
				logger.info(String.format("关闭结果查询语句成功！"));
			}
			if (con != null)
			{
				con.close();
				logger.info(String.format("关闭连接成功！"));
			}
		}

		return null;
	}
}