package com.wangwang.db;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import static com.wangwang.db.Config.URL;



/**
 *B/SӦ�ó������ӿ϶����ǵ�̬�ģ������Ϊ�˸�ϰǰ��֪ʶ�򵥸�д�ģ���������Ҫʹ�����ݿ����ӳ�DBCP
 * @author wang
 *������̬ģʽ
 */
public class DBManager {
	private static Connection con = null;

	/**
	 * ���췽��˽�У��ⲿ���ܴ�������
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
