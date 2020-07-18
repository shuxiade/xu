package com.nov.shiro.custom;

import java.util.List;

import javax.servlet.FilterChain;

import org.apache.shiro.web.filter.mgt.DefaultFilterChainManager;
import org.apache.shiro.web.filter.mgt.NamedFilterList;
import org.apache.shiro.web.filter.mgt.SimpleNamedFilterList;

public class CustomFilterChainManager extends DefaultFilterChainManager {

	public FilterChain proxy(FilterChain original, List<String> chainNames) {
		NamedFilterList configured = new SimpleNamedFilterList(chainNames.toString());
		for (String chainName : chainNames) {
			configured.addAll(getChain(chainName));
		}
		return configured.proxy(original);
	}
}
