package com.usermanagersystem.ImplDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.usermanagersystem.InterDao.InterUser;
import com.usermanagersystem.entity.User;
public class ImplUser implements InterUser {

	private Connection con;
	private PreparedStatement ps;
	private ResultSet rs;
	/**
	 * 添加管理员
	 */
	public int addAdmin(User user) {
		// TODO Auto-generated method stub
		
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_users values(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getName());
			ps.setString(4,user.getNic());
			ps.setString(5,user.getSex());
			ps.setInt(6,user.getAge());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPhone());
			ps.setString(9,user.getSelfshow());
			ps.setInt(10,user.getRoleId());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);//关闭数据库的连接
		}
		
		return num;
	
	}

	/**
	 * 查看个人信息
	 */
	public User selectUserInfo(int id)
	{
		User user=new User();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_users where id=?");
			ps.setInt(1,id);
			rs=ps.executeQuery();
			while(rs.next())
			{
				  user.setId(rs.getInt(1));
				  user.setUsername(rs.getString(2));
			      user.setPassword(rs.getString(3));
			      user.setName(rs.getString(4));
			      user.setNic(rs.getString(5));
			      user.setSex(rs.getString(6));
			      user.setAge(rs.getInt(7));
			      user.setEmail(rs.getString(8));
			      user.setPhone(rs.getString(9));
			      user.setSelfshow(rs.getString(10));
			      user.setRoleId(rs.getInt(11));
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
 
    	return user;
	}
	/**
	 * 删除用户
	 */
	public int deleteUser(int id) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
    	int count=0;
    	try {
			ps=con.prepareStatement("delete from t_users where id=?");
			ps.setInt(1,id);
			count=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);
		}
    	
    	return count;
	}
	/**
	 * 查找所有管理员信息
	 */
	public List findAllAdmins() {
		// TODO Auto-generated method stub
		List adminList=new ArrayList();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_users where roleid=1");
			rs=ps.executeQuery();
			while(rs.next())
			{
				  User user=new User();
				  user.setId(rs.getInt(1));
				  user.setUsername(rs.getString(2));
			      user.setPassword(rs.getString(3));
			      user.setName(rs.getString(4));
			      user.setNic(rs.getString(5));
			      user.setSex(rs.getString(6));
			      user.setAge(rs.getInt(7));
			      user.setEmail(rs.getString(8));
			      user.setPhone(rs.getString(9));
			      user.setSelfshow(rs.getString(10));
			      user.setRoleId(rs.getInt(11));
			      adminList.add(user);
			      
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		BaseDao.cloasAll(rs, ps, con);
    	}
    	
    	
    	return adminList;
	}
	/**
	 * 查找所有普通用户信息
	 */
	public List findAllUsers() {
		// TODO Auto-generated method stub
		
		List userList=new ArrayList();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_users where roleid=0");
			rs=ps.executeQuery();
			while(rs.next())
			{
				  User user=new User();
				  user.setId(rs.getInt(1));
				  user.setUsername(rs.getString(2));
			      user.setPassword(rs.getString(3));
			      user.setName(rs.getString(4));
			      user.setNic(rs.getString(5));
			      user.setSex(rs.getString(6));
			      user.setAge(rs.getInt(7));
			      user.setEmail(rs.getString(8));
			      user.setPhone(rs.getString(9));
			      user.setSelfshow(rs.getString(10));
			      user.setRoleId(rs.getInt(11));
			      userList.add(user);
			      
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		BaseDao.cloasAll(rs, ps, con);
    	}
    	
    	
    	return userList;
	}
	 /**
	  * 查找新增用户
	  */
	public List findNewUsers() {
		List newuserList=new ArrayList();
    	con=BaseDao.getConnection();
    	try {
			ps=con.prepareStatement("select * from t_users where roleid=0 order by id desc limit 5");
			rs=ps.executeQuery();
			while(rs.next())
			{
				  User user=new User();
				  user.setId(rs.getInt(1));
				  user.setUsername(rs.getString(2));
			      user.setPassword(rs.getString(3));
			      user.setName(rs.getString(4));
			      user.setNic(rs.getString(5));
			      user.setSex(rs.getString(6));
			      user.setAge(rs.getInt(7));
			      user.setEmail(rs.getString(8));
			      user.setPhone(rs.getString(9));
			      user.setSelfshow(rs.getString(10));
			      user.setRoleId(rs.getInt(11));
			      newuserList.add(user);		
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	finally
    	{
    		BaseDao.cloasAll(rs, ps, con);
    	}  	
    	return newuserList;
	}
	/**
	   * 用户登录判断
	   */
	public boolean login(User user) {
		// TODO Auto-generated method stub
		boolean flag=false;
		con=BaseDao.getConnection();
		try {
			ps=con.prepareStatement("select * from t_users where username=? and password=?");
		
			ps.setString(1, user.getUsername());//设置第一个变量
			ps.setString(2,user.getPassword());//设置第二个变量
			rs=ps.executeQuery();
			if(rs.next())
			{
				  user.setId(rs.getInt(1));
				  user.setUsername(rs.getString(2));
			      user.setPassword(rs.getString(3));
			      user.setName(rs.getString(4));
			      user.setNic(rs.getString(5));
			      user.setSex(rs.getString(6));
			      user.setAge(rs.getInt(7));
			      user.setEmail(rs.getString(8));
			      user.setPhone(rs.getString(9));
			      user.setSelfshow(rs.getString(10));
			      user.setRoleId(rs.getInt(11));//给user对象赋值
				flag=true;
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);//关闭数据库的连接
		}
		 return flag;
	}
	/**
	 * 修改用户信息
	 */
	public int modifyUserInfo(User user) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();//获得与数据库的连接
		int num=0;	  	    
		try {
			
			
			ps=con.prepareStatement("update t_users set username=?,password=?,name=?,nic=?,sex=?,age=?,email=?,"
					+"phone=?,selfshow=?,roleid=? where id=?");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getName());
			ps.setString(4,user.getNic());
			ps.setString(5,user.getSex());
			ps.setInt(6,user.getAge());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPhone());
			ps.setString(9,user.getSelfshow());
			ps.setInt(10,user.getRoleId());
			ps.setInt(11,user.getId());
		    num=ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
	    	BaseDao.cloasAll(rs, ps, con);
		}
		return num;
	}
	/**
	 * 注册用户
	 */
	public int addUser(User user) {
		// TODO Auto-generated method stub
		con=BaseDao.getConnection();
		int num=0;
		try {
			ps=con.prepareStatement("insert into t_users values(null,?,?,?,?,?,?,?,?,?,?)");
			ps.setString(1,user.getUsername());
			ps.setString(2,user.getPassword());
			ps.setString(3,user.getName());
			ps.setString(4,user.getNic());
			ps.setString(5,user.getSex());
			ps.setInt(6,user.getAge());
			ps.setString(7,user.getEmail());
			ps.setString(8,user.getPhone());
			ps.setString(9,user.getSelfshow());
			ps.setInt(10,user.getRoleId());
			num=ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			BaseDao.cloasAll(rs, ps, con);//关闭数据库的连接
		}
		
		return num;
	
	}
  public int  getUserid(String username,String password)
  {
	  con=BaseDao.getConnection();
	  int id=0;
	  try {
		ps=con.prepareStatement("select id from t_users where username=? and password=?");
		ps.setString(1,username);
		ps.setString(2,password);
		rs=ps.executeQuery();
		if(rs.next())
		{
			id=rs.getInt(1);
		}
		
		
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	finally
	{
		BaseDao.cloasAll(rs, ps, con);
	}
	  
	  return id;
  }
  /**
   * 查询用户roleId
   */
  public int getUserroleId(int id)
  {
	  int roleId=-1;
	  con=BaseDao.getConnection();
	  try {
		ps=con.prepareStatement("select roleid from t_users where id=?");
		ps.setInt(1,id);
		rs=ps.executeQuery();
		if(rs.next())
		{
			roleId=rs.getInt(1);
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  return roleId;
  }
  /**
   * 判读是否存在用户名
   */
  public boolean isExistUsername(String username)
  {
	  boolean flag=false;
	  con=BaseDao.getConnection();
	  try {
		ps=con.prepareStatement("select * from t_users where username=?");
		ps.setString(1,username);
		rs=ps.executeQuery();
		if(rs.next())
		{
			flag=true;
		}
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	finally
	{
		BaseDao.cloasAll(rs, ps, con);
	}
	  
	  return flag;
	  
  }
}
