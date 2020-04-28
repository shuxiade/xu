package com.example.demo.ServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.Dao.GoodDao;
import com.example.demo.Service.IGoodService;

@Service
public class GoodService implements IGoodService{
	@Autowired
	private GoodDao goodDao;
	
	public String findAll() {
		
		goodDao.findAll();
		return "";
	}
}
