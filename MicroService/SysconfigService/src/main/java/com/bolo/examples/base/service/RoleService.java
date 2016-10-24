package com.bolo.examples.base.service;

import java.io.Serializable;
import java.util.List;

import org.springframework.stereotype.Component;

import com.bolo.examples.base.entity.Role;

/**
 * 角色管理
 * @author 菠萝大象
 */


public interface RoleService {

	public List<Role> getRoles();
	
	public Role getRole(Serializable id);
	
	public void save(Role role);
	
	public void delete(Serializable id);
}
