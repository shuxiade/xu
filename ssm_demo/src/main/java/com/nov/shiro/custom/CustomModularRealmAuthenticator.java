package com.nov.shiro.custom;

import java.util.Collection;

import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.pam.ModularRealmAuthenticator;
import org.apache.shiro.realm.Realm;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CustomModularRealmAuthenticator extends ModularRealmAuthenticator {

	private static final Logger log = LoggerFactory.getLogger(CustomModularRealmAuthenticator.class);

	@Override
	protected AuthenticationInfo doMultiRealmAuthentication(Collection<Realm> realms, AuthenticationToken token) {

		return super.doMultiRealmAuthentication(realms, token);
	}

}
