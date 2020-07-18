package com.nov.listener;

import org.apache.shiro.session.Session;
import org.apache.shiro.session.SessionListenerAdapter;

/**
 * 可以只监听其中一种事件
 * @author Administrator
 *
 */
public class MySessionListenerAdapter extends SessionListenerAdapter{
	
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
