/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.restaurant.dao.RestaurantDao;
import com.promineotech.restaurant.entity.Restaurant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Service
@Slf4j
public class DefaultRestaurantService implements RestaurantService {
	
	@Autowired 
	private RestaurantDao restaurantDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<Restaurant> fetchRestaurants(String restaurantName) {
		log.info("The fetchRestaurant method was called with restaurantName={}");
		return restaurantDao.fetchRestaurants(restaurantName);
	}

	@Override
	public Optional<Restaurant> createRestaurant(int restaurantId, String restaurantName, int menuId, int customerId) {
		log.info("The createRestaurant method was called with restaurantID={}, restaurantName={}, menuId={}, customerId={}", restaurantId, restaurantName, menuId, customerId);
		return restaurantDao.createRestaurant(restaurantId, restaurantName, menuId, customerId);
	}

	@Override
	public Optional<Restaurant> updateRestaurantName(int restaurantId, String restaurantName) {
		log.info("The updateRestaurantName method was called with restaurantID={}, restaurantName={}", restaurantId, restaurantName);
		return restaurantDao.updateRestaurantName(restaurantId, restaurantName);
	}

	@Override
	public Optional<Restaurant> deleteRestaurant(int restaurantId) {
		
		return restaurantDao.deleteRestaurant(restaurantId);
	}

}
