package com.nov.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nov.dao.intf.MenuDao;
import com.nov.entity.Menu;
import com.nov.service.intf.IMenuService;

@Service
public class MenuService implements IMenuService {

	@Autowired
	private MenuDao menuDao;
	
	public List<Menu> getMenu(String roleId){
		
		
		return menuDao.getMenu(roleId);
	}

}
