/**
 * 
 */
package com.promineotech.restaurant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.promineotech.ComponentScanMarker;

/**
 * @author zacha
 *
 */
@SpringBootApplication(scanBasePackageClasses = {ComponentScanMarker.class})
public class RestaurantApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SpringApplication.run(RestaurantApp.class, args);

	}

}
