/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import com.promineotech.restaurant.entity.Customer;

/**
 * @author zacha
 *
 */
public interface CustomerService {

	/**
	 * @param firstName
	 * @return
	 */
	List<Customer> fetchCustomers(String firstName);

}
