package com.ibm.Menu.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.ibm.Menu.model.MenuItem;
import com.ibm.Menu.repo.MenuRepo;

import static org.mockito.Mockito.when;
import static org.mockito.Mockito.verify;

class MenuServiceImplTest {
	@Mock
	private MenuRepo menuRepo;
	
	@InjectMocks
	private MenuServiceImpl menuService;
	
	@BeforeEach
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@DisplayName("Test MenuService getMenuItem with valid menu item number")
	@Test
	void testGetMenuItemExistingMenuNumber() {
		// Given - set the parameter values and mock the methods for this test case
		String menuItemNumber = "0123";
		MenuItem menuItemMocked = new MenuItem("M123", "Entree", "Salmon Dinner", "Salmon with vegetables and rice", 8, 12.95);
		when(menuRepo.findByMenuItemNumber(menuItemNumber)).thenReturn(menuItemMocked);
		
		// When - call the method being tested and save the response
		MenuItem menuItem = menuService.getMenuItem(menuItemNumber);
		
		// Then - check that the results are valid (and that the expected mocked methods are called)
		assertNotNull(menuItem, "Menu item should not be null");
		assertEquals(menuItem, menuItemMocked, "Menu item should be the same as" + menuItemMocked);
		
		verify(menuRepo).findByMenuItemNumber(menuItemNumber);
	}
}
