package com.ibm.Menu.service;

import java.util.List;

import com.ibm.Menu.model.MenuItem;

public interface MenuService {
	public MenuItem getMenuItem(String menuItemNumber);
	public List<MenuItem> getMenuItems();
	public MenuItem addMenuItem(MenuItem menuItem);
//	public MenuItem addMenuItem(MenuInput menuInput);

}
