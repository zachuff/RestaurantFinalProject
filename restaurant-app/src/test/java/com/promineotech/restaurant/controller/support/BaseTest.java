 /**
 * 
 */
package com.promineotech.restaurant.controller.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;

import lombok.Getter;

/**
 * @author zacha
 *
 */
public class BaseTest {
	@LocalServerPort
	private int serverPort;
	
	@Autowired
	@Getter
	private TestRestTemplate restTemplate;
	
	protected String getBaseUri() {
		return String.format("http://localhost:%d/restaurant", serverPort);
	}

}
