package com.nov.shiro.custom;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.FilterChain;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.shiro.web.filter.mgt.PathMatchingFilterChainResolver;

/**
 * 重写
 * @author Administrator
 *
 */
public class CustomPathMatchingFilterChainResolver extends PathMatchingFilterChainResolver {

	private CustomFilterChainManager customFilterChainManager;

	public void setCustomFilterChainManager(CustomFilterChainManager customFilterChainManager) {
		this.customFilterChainManager = customFilterChainManager;
		setFilterChainManager(customFilterChainManager);
	}
	
	public CustomFilterChainManager getCustomFilterChainManager() {
        return customFilterChainManager;
    }
	
	public FilterChain getChain(ServletRequest request, ServletResponse response, FilterChain originalChain) {
		CustomFilterChainManager filterChainManager = getCustomFilterChainManager();
		if (!filterChainManager.hasChains()) {
			return null;
		}
		String requestURI = getPathWithinApplication(request);
		List<String> chainNames = new ArrayList<String>();
		for (String pathPattern : filterChainManager.getChainNames()) {
			if (pathMatches(pathPattern, requestURI)) {
				chainNames.add(pathPattern);
			}
		}
		if (chainNames.size() == 0) {
			return null;
		}
		return customFilterChainManager.proxy(originalChain, chainNames);
	}
}
