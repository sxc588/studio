package com.bjsxt.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.springframework.stereotype.Component;

import com.bjsxt.dao.UserDao;
import com.bjsxt.model.User;
import com.bjsxt.util.SystemUtil;

@Component
public class UserDaoImpl implements UserDao
{
	@Resource
	private DataSource dataSource;
	
	@Override
	public int save(User user)
	{
		try
		{
			Connection conn = dataSource.getConnection();
			ResultSet rs = conn.createStatement().executeQuery("insert into t_user (id, name,age) values(16, 'zhnagsang',6);");
			conn.close();
			System.out.println(SystemUtil.currentTimeStamp() + " user saved!");
			
		} catch (SQLException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return 0;
	}

	@Override
	public int delete()
	{
		// TODO Auto-generated method stub
		return 0;
	}

}
