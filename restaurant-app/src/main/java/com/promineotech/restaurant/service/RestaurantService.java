/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;
import java.util.Optional;

import com.promineotech.restaurant.entity.Restaurant;

/**
 * @author zacha
 *
 */
public interface RestaurantService {

	/**
	 * @param location
	 * @return
	 */
	List<Restaurant> fetchRestaurants(String restaurantName);
	
	Optional<Restaurant> createRestaurant(int restaurantId, String restaurantName, int menuId, int customerId);
	  
	Optional<Restaurant> updateRestaurantName(int restaurantId, String restaurantName);

	Optional<Restaurant> deleteRestaurant(Long restaurantPK);


}
