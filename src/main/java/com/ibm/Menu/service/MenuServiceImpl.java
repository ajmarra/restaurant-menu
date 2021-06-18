package com.ibm.Menu.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ibm.Menu.model.MenuItem;
import com.ibm.Menu.repo.MenuRepo;

@Service
public class MenuServiceImpl implements MenuService{
	
	private final Logger logger = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private MenuRepo menuRepo;

	@Override
	public MenuItem getMenuItem(String menuItemNumber) {
		logger.info("Entered MenuServiceImpl.getMenuItem().  menuItemNumber=" + menuItemNumber);
		
		MenuItem menuItem = this.menuRepo.findByMenuItemNumber(menuItemNumber);
		
		logger.info("Leaving MenuServiceImpl.getMenuItem().  menuItemNumber=" + menuItemNumber);
		return menuItem;
	}

	@Override
	public List<MenuItem> getMenuItems() {
		logger.info("Entered MenuServiceImpl.getMenuItems()");
		
		List<MenuItem> menuItems = this.menuRepo.findAll();
		
		logger.info("Leaving MenuServiceImpl.getMenuItems()");
		return menuItems;
	}
	
	@Override
	public MenuItem addMenuItem(MenuItem menuItem) {
		logger.info("Entered MenuServiceImpl.addMenuItem() menuItemNumber= " + menuItem.getMenuItemNumber());
		
		menuItem = this.menuRepo.insert(menuItem);
		
		logger.info("Leaving MenuServiceImpl.addMenuItem() menuItemNumber= " + menuItem.getMenuItemNumber());
		return menuItem;
	}

}
