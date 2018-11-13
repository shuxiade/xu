package com.nov.service;

import java.util.List;

import com.nov.entity.User;

public interface IUserService {
	
	public User findById(int userId);
	public List<User> findAll();
}
