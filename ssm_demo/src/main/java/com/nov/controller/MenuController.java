package com.nov.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.nov.service.impl.MenuService;

@Controller
@RequestMapping("/menu")
public class MenuController {

	@Autowired
	private MenuService menuService;
	
	@RequestMapping("select")
	public String select() {
		return "";
	}
	
	@RequestMapping("update/{menuId}")
	public String update() {
		return "";
	}
	
	@RequestMapping("toUpdate/{menuId}")
	public String toUpdate() {
		return "";
	}
	
	@RequestMapping("add")
	public String add() {
		return "";
	}
	
	@RequestMapping("delete/{menuId}")
	public String delete() {
		return "";
	}
	
}
