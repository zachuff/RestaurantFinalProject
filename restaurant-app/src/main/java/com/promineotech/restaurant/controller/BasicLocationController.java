/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurant.entity.Location;

import com.promineotech.restaurant.service.LocationService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@RestController
@Slf4j
public class BasicLocationController implements LocationController {
	 private LocationService locationService;
	  
	 
	  @Override
	  public List<Location> fetchLocations(String streetAddress) {
	    log.info("streetAddress={}", streetAddress);
	    return locationService.fetchLocation(streetAddress);
	  }


}
