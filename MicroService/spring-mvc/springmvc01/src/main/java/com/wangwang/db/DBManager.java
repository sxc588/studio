package com.wangwang.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import static com.wangwang.db.Config.URL;



/**
 *B/S应用程序连接肯定不是单态的，这边是为了复习前面知识简单改写的，后面我们要使用数据库连接池DBCP
 * @author wang
 *懒汉单态模式
 */
public class DBManager {
	private static Connection con = null;

	/**
	 * 构造方法私有，外部不能创建对象
	 */
	private DBManager() {
		
	}
	public synchronized static Connection getConnection() 
		throws ClassNotFoundException, SQLException{
		
		if (con == null) {
			Class.forName(Config.DRIVER);
			con = DriverManager.getConnection(URL + Config.DBNAME, Config.UNAME, Config.PWD);
		} 
		return con;
	}
}
