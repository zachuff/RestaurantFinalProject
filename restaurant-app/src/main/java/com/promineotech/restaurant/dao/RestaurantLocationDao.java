/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.util.List;
import com.promineotech.restaurant.entity.RestaurantLocation;

/**
 * @author zacha
 *
 */
public interface RestaurantLocationDao {

	/**
	 * @param menuId
	 * @return
	 */
	List<RestaurantLocation> fetchRestaurantLocations(int menuId);

}
