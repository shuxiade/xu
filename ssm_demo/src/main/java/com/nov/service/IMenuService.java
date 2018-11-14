package com.nov.service;

import java.util.List;

import com.nov.entity.Menu;

public interface IMenuService {

	public List<Menu> getMenu(int roleId);
}
