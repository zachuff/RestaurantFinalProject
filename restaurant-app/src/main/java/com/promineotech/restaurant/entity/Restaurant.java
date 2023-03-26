/**
 * 
 */
package com.promineotech.restaurant.entity;


import lombok.Builder;
import lombok.Data;

/**
 * @author zacha
 *
 */
@Data
@Builder
public class Restaurant {


	private int restaurantId;

	private String restaurantName;
	
	private int menuId;

	private int customerId;
	

}
