package com.nov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nov.entity.User;
import com.nov.service.impl.UserService;

@RestController
public class HelloController {

	@Autowired
	UserService userService;
	@RequestMapping("/hello/{id}")
	public List<User> test(@PathVariable int id) {
		
		return userService.findAll();
	}
}
