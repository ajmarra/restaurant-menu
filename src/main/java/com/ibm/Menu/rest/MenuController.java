package com.ibm.Menu.rest;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ibm.Menu.model.MenuItem;
import com.ibm.Menu.service.MenuService;


@RestController
@RequestMapping(value = "/menu")
public class MenuController {
	
	@Autowired
	private MenuService menuService;
	
	private final Logger logger = LoggerFactory.getLogger(MenuController.class);

	// URL: http://ip-address:port/menu/menu (POST request)
	@RequestMapping(value = "/menu", method = RequestMethod.POST)
	public ResponseEntity<?> addMenuItem(@RequestBody MenuItem menuItem) {

		menuItem = this.menuService.addMenuItem(menuItem);
		ResponseEntity<MenuItem> responseEntity = new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		return responseEntity;
	}

	// URL: http://ip-address:port/menu/menu/O123 (GET request)
	@RequestMapping(value = "/menu/{menuItemNumber}")
	public ResponseEntity<?> geMenuItem(@PathVariable(value="menuItemNumber") String menuItemNumber) {

		logger.info("Entered MenuController.getMenuItem().  menuItemNumber=" + menuItemNumber);
		MenuItem menuItem = this.menuService.getMenuItem(menuItemNumber);
		logger.debug("MenuController.getMenuItem().  menuItem=" + menuItem);
		ResponseEntity<MenuItem> responseEntity = new ResponseEntity<MenuItem>(menuItem, HttpStatus.OK);
		return responseEntity;
   }
   
   // URL: http://ip-address:port/menu/menuitems (GET request)
   @RequestMapping(value = "/menuitems")
   public ResponseEntity<?> getMenuItems() {
	   
	   List<MenuItem> menuItems = this.menuService.getMenuItems();
	   ResponseEntity<List<MenuItem>> responseEntity = new ResponseEntity<List<MenuItem>>(menuItems, HttpStatus.OK);
	   return responseEntity;
   }
}
