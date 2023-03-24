/**
 * 
 */
package com.promineotech.restaurant.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.promineotech.restaurant.entity.Restaurant;
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
@RequestMapping("/Restaurant")
@OpenAPIDefinition(info = @Info(title = "Restaurant Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface RestaurantController {
	// @formatter:off
	@Operation(
			summary = "Returns a list of Restaurants",
			description = "Returns a list of Restaurants given an optional name",
			responses = {
					@ApiResponse(
							responseCode = "200", 
							description = "A list of Restaurants is returned", 
							content = @Content(
									mediaType = "application/json", 
									schema = @Schema(implementation = Restaurant.class))),
					@ApiResponse(responseCode = "400", 
							description = "The request parameters are invalid", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(responseCode = "404", 
							description = "No Restaurants were found with the input criteria", 
							content = @Content(
									mediaType = "application/json")),
					@ApiResponse(responseCode = "500", 
					description = "An unplanned error occured", 
					content = @Content(
							mediaType = "application/json"))
			},
			parameters = {
				@Parameter(
					name = "restaurantName", 
					allowEmptyValue = false, 
					required = false, 
					description = "The restaurant name (i.e., McDonalds")
					
			}
			)
	@GetMapping
	 @ResponseStatus(code = HttpStatus.OK)
	List<Restaurant> fetchRestaurants(@RequestParam(required = false)String restaurantName);
	 
	@Operation(
		      summary = "Create a new restaurant",
		      description = "Create a restaurant using the required restaurantId, restaurantName, menuId, and customerId",
		      responses = {
		          @ApiResponse(
		              responseCode = "201", 
		              description = "A restaurant is created.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Restaurant.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "Unable to create a restaurant with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json")) },
		 
		      parameters = {
		          @Parameter(
		              name = "restaurantID", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The restaurantID (i.e., '7')"), 
		          @Parameter(
		              name = "restaurantName",
		              allowEmptyValue = false,
		              required = true,
		              description = "The restaurantName (i.e., 'McDonalds')"), 
		          @Parameter(
		              name = "menuId",
		              allowEmptyValue = false,
		              required = true,
		              description = "The menuId (i.e., '11')"),
		          @Parameter(
		              name = "customerId",
		              allowEmptyValue = false,
		              required = true,
		              description = "The customerId (i.e., '5')") 
		     }
		  )
		     
		 //This will create a new restaurant
		  @PostMapping 
		  @ResponseStatus(code = HttpStatus.CREATED)
		  Optional<Restaurant> createRestaurant(
		      @RequestParam (required = true)
		      int restaurantID,
		      @RequestParam (required = true)
		      String restaurantName,
		      @RequestParam (required = true)
		      int menuId,
		      @RequestParam (required = true)
		      int customerId);
		  
		  @Operation(
		      summary = "Update the name of a restaurant",
		      description = "Update the name of a restaurant using the required restaurantID",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "The restaurant name is updated.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Restaurant.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "Unable to update the restaurant name with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json")) },
		 
		      parameters = {
		          @Parameter(
		              name = "location", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The location (i.e., 'Los Angeles')"), 
		      
		     }
		  )
		     
		 //This will update the price of a dress
		  @PutMapping 
		  @ResponseStatus(code = HttpStatus.OK)
		  Optional<Restaurant> updateRestaurantName(
		      @RequestParam (required = true)
		      int restaurantID,
		      @RequestParam (required = false)
		      String location);
		  
		  @Operation(
		      summary = "Delete a restaurant",
		      description = "Delete a restaurant using the required restaurantPK",
		      responses = {
		          @ApiResponse(
		              responseCode = "200", 
		              description = "The restaurant is deleted.", 
		              content = @Content(
		                  mediaType = "application/json", 
		              schema = @Schema(implementation = Restaurant.class))),
		          @ApiResponse(
		              responseCode = "400", 
		              description = "The request parameters are invalid.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "404", 
		              description = "Unable to delete the restaurant with the input criteria.", 
		              content = @Content(
		                  mediaType = "application/json")),
		          @ApiResponse(
		              responseCode = "500", 
		              description = "An unplanned error occurred.", 
		              content = @Content(
		                  mediaType = "application/json")) },
		 
		      parameters = {
		          @Parameter(
		              name = "restauarantPK", 
		              allowEmptyValue = false, 
		              required = true, 
		              description = "The restaurantPK (i.e., '8')"), 
		     }
		  )
		     
		 //This will delete a dress dress
		  @DeleteMapping 
		  @ResponseStatus(code = HttpStatus.OK)
		  Optional<Restaurant> deleteRestaurant(
		      @RequestParam (required = true)
		      Long dressPK);
		
	// @formatter:on
}
