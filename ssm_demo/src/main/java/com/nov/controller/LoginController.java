package com.nov.controller;

import javax.servlet.http.HttpServletRequest;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping("/login")
	public String login() {
		return "404";
	}
	
	@RequestMapping(value="/validate",method=RequestMethod.POST)
	public String validate(@RequestParam String username,
							@RequestParam String password,
							HttpServletRequest request) {
		UsernamePasswordToken token = new UsernamePasswordToken(username,password);
		Subject subject =SecurityUtils.getSubject();
		String error = "";
		try {
			subject.login(token);
		}catch (UnknownAccountException e) {
			error = "用户名/密码错误";
		}
		if(error=="") {
			return "index";
		}else {
			request.setAttribute("error", error);
			return "login";
		}
	}
	
}
