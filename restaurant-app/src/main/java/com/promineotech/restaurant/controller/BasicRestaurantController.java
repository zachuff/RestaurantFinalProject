/**
 * 
 */
package com.promineotech.restaurant.controller;


import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurant.entity.Restaurant;
import com.promineotech.restaurant.service.RestaurantService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@RestController
@Slf4j
public class BasicRestaurantController implements RestaurantController {

	@Autowired
	private RestaurantService restaurantService;
	
	//Get: Read restaurants
	@Override
	public List<Restaurant> fetchRestaurants(String restaurantName) {
		log.info("restaurantName={}", restaurantName);
		return restaurantService.fetchRestaurants(restaurantName);
	}

	@Override
	public Optional<Restaurant> createRestaurant(int restaurantId, String restaurantName, int menuId, int customerId) {
		log.info("restaurantId={}, restaurantName={}, menuId={}, customerId={}", restaurantId, restaurantName, menuId, customerId);
		return restaurantService.createRestaurant(restaurantId, restaurantName, menuId, customerId);
	}

	@Override
	public Optional<Restaurant> updateRestaurantName(int restaurantId, String restaurantName) {
		log.info("restaurantId={}, restaurantName={}", restaurantId, restaurantName);
		return restaurantService.updateRestaurantName(restaurantId, restaurantName);
	}

	@Override
	public Optional<Restaurant> deleteRestaurant(int restaurantId) {
		// TODO Auto-generated method stub
		return restaurantService.deleteRestaurant(restaurantId);
	}

}
