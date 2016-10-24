package com.bolo.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.base.entity.User;
import com.bolo.examples.base.vo.UserRegist;
import com.huawei.support.commquery.MyBatisDao;

/**
 * 人员管理
 * @author 菠萝大象
 */
public interface UserService {

	public List queryResult(User user);
	
	public User getUser(Serializable id);
	
	
	public UserRegist selectByUserId(String userId);
	
	public int updateUserPic(UserRegist userRegist);
}
