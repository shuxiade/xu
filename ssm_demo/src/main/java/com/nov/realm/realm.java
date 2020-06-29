package com.nov.realm;

import java.util.List;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import com.nov.entity.Menu;
import com.nov.entity.Role;
import com.nov.entity.User;
import com.nov.service.IMenuService;
import com.nov.service.IRoleService;
import com.nov.service.IUserService;

public class realm extends AuthorizingRealm {

	@Autowired
	private IRoleService roleService;

	@Autowired
	private IUserService userService;

	@Autowired
	private IMenuService menuService;

	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
		SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
		String username = (String) principals.getPrimaryPrincipal();
		User user = userService.findByUsername(username);
		List<Role> roles = roleService.getRole(user.getUserId());
		for (Role role : roles) {
			List<Menu> menus = menuService.getMenu(role.getRoleId());
			simpleAuthorizationInfo.addRole(role.getRoleName());
			for (Menu menu : menus) {
				simpleAuthorizationInfo.addStringPermission(menu.getPerms());
			}
		}
		return simpleAuthorizationInfo;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authToken) throws AuthenticationException {
		UsernamePasswordToken token = (UsernamePasswordToken) authToken;
		String username = (String) token.getPrincipal();
		User user = userService.findByUsername(username);
		if (user == null) {
			throw new UnknownAccountException("用户名/密码错误");
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, user.getPassword(),
				ByteSource.Util.bytes(user.getSalt()), getName());
		Session session = SecurityUtils.getSubject().getSession();
		session.setAttribute("user", user);
		return simpleAuthenticationInfo;
	}

	public void clearCacheAuthorizationInfo() {
		this.clearCachedAuthorizationInfo(SecurityUtils.getSubject().getPrincipals());
	}

}
