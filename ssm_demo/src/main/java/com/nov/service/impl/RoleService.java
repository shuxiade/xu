package com.nov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nov.dao.RoleDao;
import com.nov.entity.Role;
import com.nov.service.IRoleService;

@Service
public class RoleService implements IRoleService {

	@Autowired
	RoleDao roleDao;
	
	public List<Role> getRole(int userId) {
		
		return roleDao.getRole(userId);
	}

	@Override
	public List<Role> findAll() {
		
		return roleDao.findAll();
	}
}
