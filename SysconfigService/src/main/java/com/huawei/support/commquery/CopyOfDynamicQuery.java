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
import javax.naming.spi.DirStateFactory.Result;

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

public class CopyOfDynamicQuery
{
	
	
	
	// // 数据库的连接驱动，一般是不需要变的
	// private static final String DRIVER =
	// "com.microsoft.jdbc.sqlserver.SQLServerDriver";
	// // 数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
	// private static final String URL =
	// "jdbc:microsoft:sqlserver://localhost:1433;DatabaseName=test";
	// // 登录账户
	// private static final String DBNAME = "sa";
	// // 登录的密码
	// private static final String DBPASS = "123";

	public static void main(String[] args) throws SQLException
	{
		// 数据库的连接驱动，一般是不需要变的
		String DRIVER = "com.mysql.jdbc.Driver";
		// 数据库连接的URL,1433为默认的数据库端口号，test为当前你要操作的数据库名
		String URL = "jdbc:mysql://localhost:3306/test";
		// 登录账户
		String DBNAME = "root";
		// 登录的密码
		String DBPASS = "root";
		String sql = "select* from account where 1=1";

		List<Map<String, String>> result = Query(DRIVER, URL, DBNAME, DBPASS, sql);

		System.out.println(result);
	}

	public static
			List<Map<String, String>>
			Query(String DRIVER, String URL, String DBNAME, String DBPASS, String sql) throws SQLException
	{
		Connection con = null;
		PreparedStatement psm = null;
		ResultSet resultSet = null;
		try
		{
			Class.forName(DRIVER);
			con = DriverManager.getConnection(URL, DBNAME, DBPASS);

			psm = con.prepareStatement(sql);
			resultSet = psm.executeQuery();

			ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
			 for(int i=0; i<resultSetMetaData.getColumnCount(); i++)
			 {
		//	 System.out.print( resultSetMetaData.getColumnLabel(i) + "\t" );
		//	 System.out.print( resultSetMetaData.getColumnName(i+1) + "\t" );
	//		 System.out.println( resultSetMetaData.getColumnTypeName(i) );
			 }
			//
			// while (resultSet.next())
			// {
			// System.out.println(resultSet.getString("aPassword"));
			// }
			//

//			for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
//			{
//				System.out.print(resultSetMetaData.getColumnLabel(i) + "\t");
//				System.out.print(resultSetMetaData.getColumnName(i) + "\t");
//				System.out.println(resultSetMetaData.getColumnTypeName(i));
//			}

			List<Map<String, String>> resultList = new ArrayList<Map<String, String>>();
			while (resultSet.next())
			{
				// System.out.println(resultSet.getString("aPassword"));

				Map<String, String> rowMap = new HashMap<String, String>();
				for (int i = 0; i < resultSetMetaData.getColumnCount(); i++)
				{
					String column = resultSetMetaData.getColumnName(i+1);
					String value = resultSet.getString(column);

					rowMap.put(column, value);
				}
				resultList.add(rowMap);
			}

			return resultList;
		}
		catch (Exception e)
		{
			e.printStackTrace();
		}
		finally
		{
			if (resultSet != null)
			{
				resultSet.close();
			}
			if (psm == null)
			{
				psm.close();
			}
			if (con != null)
			{
				con.close();
			}
		}

		return null;
	}
}