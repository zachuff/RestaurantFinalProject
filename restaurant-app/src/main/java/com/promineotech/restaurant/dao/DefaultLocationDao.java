/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.restaurant.entity.Customer;
import com.promineotech.restaurant.entity.Location;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Component
@Slf4j
public class DefaultLocationDao implements LocationDao {

	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	
	  @Override
	  public List<Location> fetchLocations (String streetAddress) {
	    log.info("DAO: streetAddress={}", streetAddress);
	 
	    //@formatter:off
	    String sql =""
	        + "SELECT * "
	        + "FROM location "
	        + "WHERE street_address = :street_address";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("street_address", streetAddress);
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {
	      
	      @Override
	      public Location mapRow(ResultSet rs, int rowNum) throws SQLException {
	        //formatter:off
	        return Location.builder()
	            .locationPK(rs.getLong("location_pk"))
	            .locationId(rs.getInt("location_id"))
	            .streetAddress(rs.getString("street_address"))
	            .city(rs.getString("city"))
	            .state(rs.getString("state"))
	            .build();
	      } });
	      
	      
	    
	  }
}
