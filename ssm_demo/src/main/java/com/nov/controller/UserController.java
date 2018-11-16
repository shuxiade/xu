package com.nov.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nov.entity.User;
import com.nov.service.impl.UserService;


@Controller
@RequestMapping("/admin")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/select")
	public List<User> select(){
		List<User> users = userService.findAll();
		return users;
	}
	@PostMapping("add")
	public String add() {
		
		return "indexs";
	}

	@PostMapping("delete")
	public String delete(@PathVariable int id) {
		
		return "";
	}
	
	@PostMapping("udpate")
	public String update(User user) {
	
		return "";
	}
}
