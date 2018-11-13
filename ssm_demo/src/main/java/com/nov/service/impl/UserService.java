package com.nov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nov.dao.UserDao;
import com.nov.entity.User;
import com.nov.service.IUserService;

@Service("userService")
public class UserService implements IUserService {

	@Autowired
	UserDao userDao;
	@Override
	public User findById(int userId) {
		
		return userDao.findById(userId);
	}
	@Override
	public List<User> findAll() {
		return userDao.findAll();
	}
	
	

}
