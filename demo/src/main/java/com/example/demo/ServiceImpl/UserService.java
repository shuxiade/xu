package com.example.demo.ServiceImpl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.example.demo.Dao.IUserDao;
import com.example.demo.Entity.User;
import com.example.demo.Service.IUserService;

@Service
public class UserService implements IUserService{

	
	@Resource
	private IUserDao userDao;

	@Override
	public String findAll() {
		List<User> list = userDao.findAll();
		User u = new User();
		return list.toString();
	}

}
