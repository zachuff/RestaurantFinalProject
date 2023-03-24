/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import com.promineotech.restaurant.entity.Customer;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Component
@Slf4j
public class DefaultCustomerDao implements CustomerDao {


	  @Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	
	  @Override
	  public List<Customer> fetchCustomers (String firstName) {
	    log.info("DAO: firstName={}", firstName);
	 
	    //@formatter:off
	    String sql =""
	        + "SELECT * "
	        + "FROM customer "
	        + "WHERE first_name = :first_name";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("first_name", firstName);
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {
	      
	      @Override
	      public Customer mapRow(ResultSet rs, int rowNum) throws SQLException {
	        //formatter:off
	        return Customer.builder()
	            .customerPK(rs.getLong("customer_pk"))
	            .customerId(rs.getInt("customer_id"))
	            .phoneNumber(rs.getString("phone_number"))
	            .firstName(rs.getString("first_name"))
	            .lastName(rs.getString("last_name"))
	            .build();
	      } });
	      
	      
	    
	  }

}
