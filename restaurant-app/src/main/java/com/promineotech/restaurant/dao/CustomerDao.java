/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.util.List;

import com.promineotech.restaurant.entity.Customer;

/**
 * @author zacha
 *
 */
public interface CustomerDao {
	 List<Customer> fetchCustomers(String firstName);
}
