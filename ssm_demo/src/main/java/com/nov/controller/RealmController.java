package com.nov.controller;

import org.apache.shiro.SecurityUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.nov.shiro.realm.MailRealm;

@RequestMapping("/realm")
@RestController
public class RealmController {

	@GetMapping("get")
	public Object getRealm() {
		System.out.println(SecurityUtils.getSubject().getPrincipals().asList());
		System.out.println(SecurityUtils.getSubject().getPrincipals().getPrimaryPrincipal());
		System.out.println(SecurityUtils.getSubject().getPrincipals().fromRealm(MailRealm.class.getName()));
		System.out.println(SecurityUtils.getSubject().getPrincipals().byType(MailRealm.class));
		return "";
	}
}
