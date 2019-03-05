package com.github.support.utils.db;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

 
public class main {
 
	public static void main(String[] args) throws SQLException {
		insert_test();
		del_test();
	}
	
	static void insert_test() throws SQLException{
		Connection conn = ConnectDb.Connect();
        
        //创建SQL执行工具 
        QueryRunner qRunner = new QueryRunner(); 
        
        //执行SQL插入 
        int n = qRunner.update(conn, "insert into user(name,age) values('xxx',22)"); 
        System.out.println("成功插入" + n + "条数据！"); 
        
        //关闭数据库连接 
        DbUtils.closeQuietly(conn); 	
	} 
	
	static void select_test() throws SQLException{
		Connection conn = ConnectDb.Connect();
        
        //创建SQL执行工具 
        QueryRunner qRunner = new QueryRunner(); 
        
        @SuppressWarnings("unchecked")
		List<UserBean> list = (List<UserBean>) qRunner.query(conn, "select id,name,age from user", new BeanListHandler(UserBean.class)); 
        //输出查询结果 
        for (UserBean user : list) { 
                System.out.println(user.getAge()); 
        } 
        
        //关闭数据库连接 
        DbUtils.closeQuietly(conn); 
	} 
 
	static void update_test() throws SQLException{
		Connection conn = ConnectDb.Connect();
        
        //创建SQL执行工具 
        QueryRunner qRunner = new QueryRunner(); 
        //执行SQL插入 
        int n = qRunner.update(conn, "update user set name = 'xxx',age=28"); 
        System.out.println("成功更新" + n + "条数据！"); 
        
        //关闭数据库连接 
        DbUtils.closeQuietly(conn); 
	} 
	
	static void del_test() throws SQLException{
		Connection conn = ConnectDb.Connect();
        
        //创建SQL执行工具 
        QueryRunner qRunner = new QueryRunner(); 
        //执行SQL插入 
        int n = qRunner.update(conn, "DELETE from user WHERE name='xxx';"); 
        System.out.println("删除成功" + n + "条数据！"); 
        
        //关闭数据库连接 
        DbUtils.closeQuietly(conn); 
	} 
}
