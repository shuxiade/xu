package com.nov.controller;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.support.RequestContext;

@Controller
public class TestController {
	
	@RequestMapping("/")
	public String test() {
//		RequestContext ctx = RequestContext.getCurrentContext();
//		RequestDispatcher dispatcher = ctx.getrequest.getRequestDispatcher();
		return "";
	}
}
