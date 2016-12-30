package com.bolo.examples.base.daoImpl;

import java.io.Serializable;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import com.bolo.examples.base.dao.UserDao;
import com.bolo.examples.base.entity.UserInfo;
import com.bolo.examples.base.vo.UserRegist;


@Repository
public class UserDaoImpl extends SqlSessionDaoSupport implements UserDao{



	public void save(String key, Object object) {
		getSqlSession().insert(key, object);
	}
	

	public void delete(String key, Serializable id) {
		getSqlSession().delete(key, id);
	}


	public void delete(String key, Object object) {
		getSqlSession().delete(key, object);
	}
	

	@SuppressWarnings("unchecked")
	public <T> T get(String key, Object params) {
//		return null;
		return (T) getSqlSession().selectOne(key, params);
	}

	public <T> List<T> getList(String key) {
//		return null;
		return getSqlSession().selectList(key);
	}

	public <T> List<T> getList(String key, Object params) {
//		return null;
		return getSqlSession().selectList(key, params);
	}


	public UserRegist selectByUserId(String userId) {
		UserInfo u = getSqlSession().selectOne("userInfoMapper.selectByUserId",userId);
		UserRegist ur = new UserRegist();
		ur.setMemberId(u.getUserId());
		ur.setMemberName(u.getUserName());
		ur.setMemberNickName(u.getNickName());
		ur.setPassWord(u.getPassword());
		ur.setMemberMobile(u.getMobileNo());
		ur.setMemberEmail(u.getEmail());
		ur.setMemberCreateTime(u.getCreateTime());
		ur.setMemberImg(u.getUserPic());
		return ur;
	}

	public int updateUserPic(UserRegist userRegist) {
		int count = getSqlSession().update("userInfoMapper.updateImgByUserId", userRegist);
		return count;
	}
	
}
