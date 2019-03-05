package com.github.support.utils.db;

import java.sql.SQLException;
import java.sql.Connection;
import java.sql.DriverManager; 
 
public class ConnectDb {
	private static String driveClassName = "com.mysql.jdbc.Driver";
	private static String url = "jdbc:mysql://192.168.1.161:3306/test?useUnicode=true&characterEncoding=utf8"; 
	
	private static String user = "root";
	private static String password = "e-playnow";
	
	public static Connection Connect(){
		Connection conn = null;
		
		//load driver
		try {
			Class.forName(driveClassName);
		} catch (ClassNotFoundException  e) {
			System.out.println("load driver failed!");
			e.printStackTrace();
		}
		
		//connect db
		try {
			conn = DriverManager.getConnection(url, user, password);
		} catch (SQLException e) {
			System.out.println("connect failed!");
			e.printStackTrace();
		}		
		
		return conn;
	}
}
