package com.nov.service.intf;

import java.util.List;

import com.nov.entity.Menu;

public interface IMenuService {

	public List<Menu> getMenu(String roleId);
}
