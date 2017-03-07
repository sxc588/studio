package com.github.support.entitlement.ws.impl;

import java.util.List;
import javax.jws.WebService;
import com.github.support.entitlement.Dao.UserDao;
import com.github.support.entitlement.entity.User;
import com.github.support.entitlement.ws.UserServiceWs;

@WebService (endpointInterface= "com.github.support.entitlement.ws.UserService" ) 
public class UserServiceWsImpl implements UserServiceWs
{
	private  UserDao  userDao ; 

	@Operatora("read")
	@Override
	public void insert(String userid, String username, String useremail, int userage)
	{
		User user= new  User(); 
		user.setUserage(userage); 
		user.setUseremail(useremail); 
		user.setUserid(userid); 
		user.setUsername(username); 
		userDao.insert(user); 
		System. out .println( "insert successfully!" );
	}

	@Override
	public User getUserById(String userid)
	{
		return  userDao.findUserById(userid); 
	}

	@Override
	public List<User> getAllUsers()
	{
		return userDao.findAllUser(); 
	}

}
