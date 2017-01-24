package com.wangwang.test;

import java.sql.SQLException;

import com.wangwang.db.DBManager;

public class TestDBManager {
	public static void main(String[] args) {
		try {
			System.out.println(DBManager.getConnection());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
