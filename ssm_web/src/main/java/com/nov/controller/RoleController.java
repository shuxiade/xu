package com.nov.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nov.service.impl.RoleService;

@Controller
@RequestMapping("/role")
public class RoleController {

	Logger logger = LoggerFactory.getLogger(getClass());
	@Autowired
	private RoleService roleService;

	@RequestMapping("select")
	public String select() {
		return "";
	}

	@RequestMapping("update/{roleId}")
	public String update() {
		return "";
	}

	@RequestMapping("toUpdate/{roleId}")
	public String toUpdate() {
		return "";
	}

	@RequestMapping("add")
	public String add() {
		return "";
	}

	@RequestMapping("delete/{roleId}")
	public void delete() {

	}
}
