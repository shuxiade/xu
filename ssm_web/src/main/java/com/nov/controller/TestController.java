package com.nov.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "test")
public class TestController {

	@RequestMapping("/practice")
	public String test() {
		System.out.println("测试---------------------");
		return "practice";
	}
}
