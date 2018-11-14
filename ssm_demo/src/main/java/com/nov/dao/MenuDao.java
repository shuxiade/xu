package com.nov.dao;

import java.util.List;

import com.nov.entity.Menu;

public interface MenuDao {

	List<Menu> getMenu(int roleId);

}
