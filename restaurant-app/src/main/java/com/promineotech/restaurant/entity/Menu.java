/**
 * 
 */
package com.promineotech.restaurant.entity;

import java.math.BigDecimal;
import lombok.Builder;
import lombok.Data;

/**
 * @author zacha
 *
 */
@Data
@Builder

public class Menu {

	private Long menuPK;
	
	private int menuId;

	private String foodName;

	private String foodType;

	private BigDecimal price;

}
