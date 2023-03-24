/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.util.List;

import com.promineotech.restaurant.entity.Menu;

/**
 * @author zacha
 *
 */
public interface MenuDao {

	 List<Menu> fetchMenus(String foodName);
}
