package com.nov.service.impl;

import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nov.dao.PermDao;
import com.nov.entity.Perm;
import com.nov.service.IPermService;
@Service
public class PermService implements IPermService{

	@Autowired
	private PermDao permDao;
	
	
	@Override
	public List<Perm> getAll() {
		return permDao.getAll();
	}

}
