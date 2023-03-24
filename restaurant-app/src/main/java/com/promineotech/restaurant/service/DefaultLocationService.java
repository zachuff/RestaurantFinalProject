/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.promineotech.restaurant.dao.LocationDao;
import com.promineotech.restaurant.entity.Location;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Service
@Slf4j
public class DefaultLocationService implements LocationService {

	 @Autowired
	  private LocationDao locationDao;
	
	@Override
	public List<Location> fetchLocations(String streetAddress) {
		log.info("The fetchLocations method was called with streetAddress={}");
		return locationDao.fetchLocations(streetAddress);
	}

}
