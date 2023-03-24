/**
 * 
 */
package com.promineotech.restaurant.controller;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.jdbc.Sql;

import com.promineotech.restaurant.controller.support.FetchRestaurantTestSupport;

/**
 * @author zacha
 *
 */
@SpringBootTest
@ActiveProfiles("test")
@Sql
class FetchRestaurantTest extends FetchRestaurantTestSupport{

	@Test
	void test() {
		
	}

}
