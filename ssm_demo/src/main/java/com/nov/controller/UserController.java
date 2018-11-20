package com.nov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nov.entity.User;
import com.nov.service.impl.UserService;
import com.nov.vo.UserVo;


@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("select")
	public String select(){
		return "";
	}
	
	@RequestMapping("toUpdate/{userId}")
	public String toUpdate() {
		return "";
	}
	
	@PostMapping("udpate/{userId}")
	public String update(User user) {
		
		return "";
	}
	
	@PostMapping("toAdd")
	public String toAdd() {
		
		return "indexs";
	}
	
	@PostMapping("add")
	public String add() {
		
		return "indexs";
	}
	

	@PostMapping("delete/{userId}")
	public String delete(@PathVariable int userId) {
		
		return "";
	}
	
	@PostMapping("/get")
	public String get(UserVo entity) {
		
		return entity.toString();
	}
}
