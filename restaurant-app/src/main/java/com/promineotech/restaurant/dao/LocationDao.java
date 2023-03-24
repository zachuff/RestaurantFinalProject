/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.util.List;

import com.promineotech.restaurant.entity.Customer;
import com.promineotech.restaurant.entity.Location;

/**
 * @author zacha
 *
 */
public interface LocationDao {

	 List<Location> fetchLocations(String streetAddress);
}
