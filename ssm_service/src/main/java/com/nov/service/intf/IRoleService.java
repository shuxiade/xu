package com.nov.service.intf;

import java.util.List;

import com.nov.entity.Role;

public interface IRoleService {
	public List<Role> getRole(int userId);	

	public List<Role> findAll();
}
