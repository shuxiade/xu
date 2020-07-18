package com.nov.dao.intf;

import java.util.List;

import com.nov.entity.Role;

public interface RoleDao {

	public List<Role> getRole(int userId);
	
	public List<Role> findAll();
}
