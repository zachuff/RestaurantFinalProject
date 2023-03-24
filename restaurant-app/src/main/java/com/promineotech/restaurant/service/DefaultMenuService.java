/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.restaurant.dao.MenuDao;
import com.promineotech.restaurant.entity.Menu;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Service
@Slf4j
public class DefaultMenuService implements MenuService {

	@Autowired
	  private MenuDao menuDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Menu> fetchMenus(String foodName) {
		log.info("The fetchMenus method was called with foodName={}");
		return menuDao.fetchMenus(foodName);
	}

}
