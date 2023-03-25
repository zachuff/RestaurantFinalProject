/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.restaurant.entity.Location;
import com.promineotech.restaurant.entity.RestaurantLocation;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.servers.Server;

/**
 * @author zacha
 *
 */
@Validated
@RequestMapping("/RestaurantLocation")
@OpenAPIDefinition(info = @Info(title = "Restaurant Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface RestaurantLocationController {

	//@formatter:off
	  @Operation(
	      summary = "Returns a list of restaurant locations",
	      description = "Returns a list of restaurant locations given an optional menu ID",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A list of restaurant locations is returned.", 
	              content = @Content(
	                  mediaType = "application/json", 
	              schema = @Schema(implementation = Location.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No restaurant locations were found with the input criteria.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(
	                  mediaType = "application/json")) },
	 
	      parameters = {
	          @Parameter(
	              name = "menuId", 
	              allowEmptyValue = false, 
	              required = false, 
	              description = "The menuId (i.e., '1')")
	     }
	  )
	  //@formatter:on
	     
	 //This will return a list of restaurant locations 
	  @GetMapping 
	  @ResponseStatus(code = HttpStatus.OK)
	  List<RestaurantLocation> fetchRestaurantLocations(
	      @RequestParam(required = false)
	      int menuId);
}
