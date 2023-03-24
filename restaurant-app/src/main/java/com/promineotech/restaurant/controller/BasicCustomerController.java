/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurant.entity.Customer;
import com.promineotech.restaurant.service.CustomerService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@RestController
@Slf4j
public class BasicCustomerController implements CustomerController {
	 private CustomerService customerService;
	  
	  @Override
	  public List<Customer> fetchCustomers(String firstName) {
	    log.info("firstName={}", firstName);
	    return customerService.fetchCustomers(firstName);
	  }

}
