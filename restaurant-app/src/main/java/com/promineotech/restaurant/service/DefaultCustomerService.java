/**
 * 
 */
package com.promineotech.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.promineotech.restaurant.dao.CustomerDao;
import com.promineotech.restaurant.entity.Customer;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Service
@Slf4j
public class DefaultCustomerService implements CustomerService {

	@Autowired 
	private CustomerDao customerDao;
	
	@Transactional(readOnly=true)

	@Override
	public List<Customer> fetchCustomers(String firstName) {
		log.info("The fetchCustomers method was called with firstName={}");
		return customerDao.fetchCustomers(firstName);
	}

}
