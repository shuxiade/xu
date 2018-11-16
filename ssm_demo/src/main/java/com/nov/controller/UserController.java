package com.nov.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class UserController {
	
	@RequestMapping("add")
	@RequiresRoles("admin")
	public String addUser() {
		
		return "indexs";
	}

}
