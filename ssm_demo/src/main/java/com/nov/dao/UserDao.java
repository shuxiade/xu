package com.nov.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.nov.entity.User;

@Repository
public interface UserDao {

	public User findById(int userId);
		
	public List<User> findAll();
}
