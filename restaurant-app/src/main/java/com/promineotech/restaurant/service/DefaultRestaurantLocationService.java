/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.promineotech.restaurant.dao.RestaurantLocationDao;
import com.promineotech.restaurant.entity.RestaurantLocation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Service
@Slf4j
public class DefaultRestaurantLocationService implements RestaurantLocationService {

	@Autowired
	  private RestaurantLocationDao restaurantLocationDao;
	
	@Transactional(readOnly=true)
	@Override
	public List<RestaurantLocation> fetchRestaurantLocations(int menuId) {
		log.info("The fetchLocations method was called with streetAddress={}");
		return restaurantLocationDao.fetchRestaurantLocations(menuId);
	}


}
