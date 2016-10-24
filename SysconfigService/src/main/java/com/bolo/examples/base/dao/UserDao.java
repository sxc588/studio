package com.bolo.examples.base.dao;

import java.io.Serializable;
import java.util.List;

import com.bolo.examples.base.vo.UserRegist;

public interface UserDao {

	public void save(String key, Object object);

	public void delete(String key, Serializable id);

	public void delete(String key, Object object);

	public <T> T get(String key, Object params);

	public <T> List<T> getList(String key);

	public <T> List<T> getList(String key, Object params);

	public UserRegist selectByUserId(String userId);

	public int updateUserPic(UserRegist userRegist);
}
