package com.ibm.Menu.repo;

import com.ibm.Menu.model.MenuItem;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MenuRepo extends MongoRepository<MenuItem, Long> 
{
	public MenuItem findByMenuItemNumber(String menuItemNumber);
}