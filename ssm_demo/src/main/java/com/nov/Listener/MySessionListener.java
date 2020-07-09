package com.nov.Listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListener;

public class MySessionListener implements SessionListener {

	/**
	 * //会话创建时触发
	 */
	@Override
	public void onStart(Session session) {
		// TODO Auto-generated method stub

	}

	/**
	 * //会话过期时触发
	 */
	@Override
	public void onStop(Session session) {
		// TODO Auto-generated method stub

	}

	/**
	 * //退出/会话过期时触发
	 */
	@Override
	public void onExpiration(Session session) {
		// TODO Auto-generated method stub

	}

}
