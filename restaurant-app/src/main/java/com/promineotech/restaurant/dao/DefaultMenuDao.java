/**
 * 
 */
package com.promineotech.restaurant.dao;

import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Component;

import com.promineotech.restaurant.entity.Location;
import com.promineotech.restaurant.entity.Menu;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@Component
@Slf4j
public class DefaultMenuDao implements MenuDao {
	
	@Autowired
	  private NamedParameterJdbcTemplate jdbcTemplate;
	
	  @Override
	  public List<Menu> fetchMenus (String foodName) {
	    log.info("DAO: streetAddress={}", foodName);
	 
	    //@formatter:off
	    String sql =""
	        + "SELECT * "
	        + "FROM menu "
	        + "WHERE food_name = :food_name";
	    //@formatter:on
	    
	    Map<String, Object> params = new HashMap<>();
	    params.put("food_name", foodName);
	    
	    return jdbcTemplate.query(sql, params, new RowMapper<>() {
	      
	      @Override
	      public Menu mapRow(ResultSet rs, int rowNum) throws SQLException {
	        //formatter:off
	        return Menu.builder()
	            .menuPK(rs.getLong("menu_pk"))
	            .menuId(rs.getInt("location_id"))
	            .foodName(rs.getString("food_name"))
	            .foodType(rs.getString("food_type"))
	            .price(rs.getBigDecimal("price"))
	            .build();
	      } });
	  }

}
