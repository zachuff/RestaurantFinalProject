/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.promineotech.restaurant.entity.Location;
import com.promineotech.restaurant.entity.Menu;
import com.promineotech.restaurant.service.MenuService;

import lombok.extern.slf4j.Slf4j;

/**
 * @author zacha
 *
 */
@RestController
@Slf4j
public class BasicMenuController implements MenuController {
	 private MenuService menuService;
	  
	 
	  @Override
	  public List<Menu> fetchMenus(String foodName) {
	    log.info("foodName={}", foodName);
	    return menuService.fetchMenus(foodName);
	  }

}
