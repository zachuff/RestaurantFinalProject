/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import com.promineotech.restaurant.entity.RestaurantLocation;

/**
 * @author zacha
 *
 */
public interface RestaurantLocationService {

	/**
	 * @param menuId
	 * @return
	 */
	List<RestaurantLocation> fetchRestaurantLocations(int menuId);

}
