package com.nov.dao.intf;

import java.util.List;

import com.nov.entity.Menu;

public interface MenuDao {

	List<Menu> getMenu(String roleId);

}
