package com.nov.service;

import java.util.List;

import com.nov.entity.User;

public interface IUserService {
	
	public User findById(int userId);
	
	public List<User> findAll();
	
	public User findByUsername(String username);
	
	public User findByPhone(String phone);
	
	public User findByEmail(String email);
}
