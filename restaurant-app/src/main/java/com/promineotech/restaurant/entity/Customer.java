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

public class Customer {
	
	private Long customerPK;
	
	private int customerId;
	
	private String phoneNumber;

	private String firstName;

	private String lastName;
	
}
