package com.usermanagersystem.ImplDao;
import java.sql.*;
public class BaseDao 
{
	private static Connection con;
	/**
	 * 加载驱动
	 */
	static
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
	}
	
	/**
	 * 获得数据库连接
	 * @return
	 */
	public static Connection getConnection()
	{
		
		try {
			con=DriverManager.getConnection("jdbc:mysql://localhost:3306/usermanagersystem","root","root");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		return con;
	}
	/**
	 * 关闭与数据库的连接
	 * @param rs
	 * @param ps
	 * @param con
	 */
	public static void cloasAll(ResultSet rs,PreparedStatement ps,Connection con){
		if(rs!=null)
		{
			try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(ps!=null)
		{
			try {
				ps.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		if(con!=null)
		{
			try {
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
