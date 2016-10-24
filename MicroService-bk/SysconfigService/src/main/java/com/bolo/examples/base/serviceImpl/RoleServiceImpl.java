package com.bolo.examples.base.serviceImpl;

import java.io.Serializable;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bolo.examples.base.dao.RoleDao;
import com.bolo.examples.base.entity.Role;
import com.bolo.examples.base.service.RoleService;

/**
 * 角色管理
 * @author 菠萝大象
 */
@Service
public class RoleServiceImpl implements RoleService{

	/*@Autowired
	private MyBatisDao myBatisDao;*/
	
	@Autowired
	private RoleDao roleDaoImpl;
	
	
	public List<Role> getRoles(){
		return roleDaoImpl.getList("roleMapper.selectByEntity");
	}
	
	public Role getRole(Serializable id){
//		return null;
		return roleDaoImpl.get("roleMapper.selectByPrimaryKey",id);
	}
	
	public void save(Role role){
		//Integer a = role.getId();
		//int b = a.intValue();
		//System.out.println(b);
		if(role.getId() == null){
			roleDaoImpl.save("roleMapper.insert", role);
		}else{
			roleDaoImpl.save("roleMapper.update", role);
		}
	}
	
	public void delete(Serializable id){
		roleDaoImpl.delete("roleMapper.delete", id);
	}
}
