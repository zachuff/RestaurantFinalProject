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
import com.promineotech.restaurant.entity.RestaurantLocation;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Component
@Slf4j
public class DefaultRestaurantLocationDao implements RestaurantLocationDao {
	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	
	  @Override
	  public List<RestaurantLocation> fetchRestaurantLocations (int menuId) {
	    log.info("DAO: menuId={}", menuId);
	 
	    //@formatter:off
	    String sql =""
	        + "SELECT * "
	        + "FROM restaurant_location "
	        + "WHERE menu_id = :menu_id";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("menu_id", menuId);
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {
	      
	      @Override
	      public RestaurantLocation mapRow(ResultSet rs, int rowNum) throws SQLException {
	        //formatter:off
	        return RestaurantLocation.builder()
	            .customerId(rs.getInt("customer_id"))
	            .menuId(rs.getInt("menu_id"))
	            .build();
	      } });
	      
	      
	    
	  }

}
