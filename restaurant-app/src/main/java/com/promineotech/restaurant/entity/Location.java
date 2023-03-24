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

public class Location {
	
	private Long locationPK;

	private int locationId;

	private String streetAddress;

	private String city;

	private String state;

}
