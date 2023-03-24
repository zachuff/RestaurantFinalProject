/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import com.promineotech.restaurant.entity.Location;

/**
 * @author zacha
 *
 */
public interface LocationService {

	/**
	 * @param streetAddress
	 * @return
	 */
	List<Location> fetchLocations(String streetAddress);

}
