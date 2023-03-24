/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import com.promineotech.restaurant.entity.Location;
import com.promineotech.restaurant.entity.Menu;

/**
 * @author zacha
 *
 */
public interface MenuService {

	/**
	 * @param foodName
	 * @return
	 */
	List<Menu> fetchMenus(String foodName);

}
