/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import com.promineotech.restaurant.entity.Restaurant;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Slf4j
public class DefaultRestaurantDao implements RestaurantDao {

	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	  
	
	  @Override
	  public List<Restaurant> fetchRestaurants(String restaurantName) {
	    log.info("DAO: restaurantName={}", restaurantName);
	    
	    //@formatter:off
	    String sql = ""
	        + "SELECT * "
	        + "FROM restaurant "
	        + "WHERE restaurant_name = :restaurant_name";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<> ();
	    params.put("restaurant_name", restaurantName);

	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {
	      
	      @Override
	      public Restaurant mapRow(ResultSet rs, int rowNums) throws SQLException {
	        //formatter:off
	      return Restaurant.builder()  
	        .restaurantId(rs.getInt("restaurant_id"))
	        .restaurantName(rs.getString("restaurant_name"))
	        .menuId(rs.getInt("menu_id"))
	        .customerId(rs.getInt("customer_id"))
	        .build();
	      //formatter:on
	      } });
	      
	  }

	  @Override
	  public Optional<Restaurant> createRestaurant(int restaurantId, String restaurantName, int menuId, int customerId) {
	    log.info("DAO: restaurantId={}, restaurantName={}, menuId={}, customerId={}", restaurantId, restaurantName, menuId, customerId);
	    
	    //@formatter:off
	    String sql = ""
	        + "INSERT INTO restaurant ("
	        + "restaurant_id, restaurant_name, menu_id, customer_id"
	        + ") VALUES ("
	        + ":restaurant_id, :restaurant_name, :menu_id, :customer_id)";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("restaurant_id", restaurantId);
	    params.put("restaurant_name", restaurantName);
	    params.put("menu_id", menuId);
	    params.put("customer_id", customerId);
	    
	    
	  
	    
	    jdbcTemplate.update(sql, params);
	    return Optional.ofNullable(Restaurant.builder()
	    		.restaurantId(restaurantId)
	    		.restaurantName(restaurantName)
	    		.menuId(menuId)
	    		.customerId(customerId)
	    		.build());
	  }
 
	  @Override
	  public Optional<Restaurant> updateRestaurantName(int restaurantId, String restaurantName) {
	    log.info("DAO: restaurantId={}, restaurantName={}", restaurantId, restaurantName);
	    
	    //formatter:off
	    String sql = ""
	        + "UPDATE restaurant SET restaurant_name = :restaurant_name "
	        + "WHERE restaurant_id = :restaurant_id";
	    //formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("restaurant_id", restaurantId);
	    params.put("restaurant_name", restaurantName);
	    
	    jdbcTemplate.update(sql, params);
	    return Optional.ofNullable(Restaurant.builder()
	        .restaurantId(restaurantId)
	        .restaurantName(restaurantName)
	        .build());
	  }

	  //Delete method to delete a dress
	  @Override
	  public Optional<Restaurant> deleteRestaurant(Long restaurantPK) {
	    //@formatter:off
	    String sql = ""
	        + "DELETE FROM restaurant WHERE "
	        + "restaurant_pk = :restaurant_pk";
	    //@formatter:on
	    
	    Map <String, Object> params = new HashMap<>();
	    params.put("restaurant_pk", restaurantPK);
	    
	    jdbcTemplate.update(sql, params); 
	    
	    //shows the dressPK that was deleted
	    return Optional.ofNullable(Restaurant.builder()
	        .restaurantPK(restaurantPK)
	        .build());
	  }

}
