/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;
import com.promineotech.restaurant.entity.RestaurantLocation;
import com.promineotech.restaurant.service.RestaurantLocationService;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@RestController
@Slf4j
public class BasicRestaurantLocationController implements RestaurantLocationController {

	 private RestaurantLocationService restaurantLocationService;
	  
	 
	  @Override
	  public List<RestaurantLocation> fetchRestaurantLocations(int menuId) {
	    log.info("menuId={}", menuId);
	    return restaurantLocationService.fetchRestaurantLocations(menuId);
	  }

}
