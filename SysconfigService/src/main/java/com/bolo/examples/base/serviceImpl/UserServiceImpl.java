package com.bolo.examples.base.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.base.dao.UserDao;
import com.bolo.examples.base.entity.User;
import com.bolo.examples.base.service.UserService;
import com.bolo.examples.base.vo.UserRegist;

/**
 * 人员管理
 * @author 菠萝大象
 */
@Service
public class UserServiceImpl implements UserService{

	/*@Autowired
	private MyBatisDao myBatisDao;*/
	
	@Autowired
	private UserDao userDaoImpl;
	
	
	
	/**
	 * 根据条件查询
	 */
	public List queryResult(User user){
		return userDaoImpl.getList("userMapper.selectByQuery",user);
	}
	
	public User getUser(Serializable id){
		return userDaoImpl.get("userMapper.selectByPrimaryKey",id);
	}

	
	public UserRegist selectByUserId(String userId) {
		return userDaoImpl.selectByUserId(userId);
	}


	public int updateUserPic(UserRegist userRegist) {
		return userDaoImpl.updateUserPic(userRegist);
	}
}
