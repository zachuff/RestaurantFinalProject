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
import com.promineotech.restaurant.entity.Menu;

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
@RequestMapping("/Menu")
@OpenAPIDefinition(info = @Info(title = "Restaurant Service"), servers = {
		@Server(url = "http://localhost:8080", description = "Local Server.")})
public interface MenuController {

	//@formatter:off
	  @Operation(
	      summary = "Returns a list of menus",
	      description = "Returns a list of locations given an optional food name",
	      responses = {
	          @ApiResponse(
	              responseCode = "200", 
	              description = "A list of menus is returned.", 
	              content = @Content(
	                  mediaType = "application/json", 
	              schema = @Schema(implementation = Menu.class))),
	          @ApiResponse(
	              responseCode = "400", 
	              description = "The request parameters are invalid.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "404", 
	              description = "No menus were found with the input criteria.", 
	              content = @Content(
	                  mediaType = "application/json")),
	          @ApiResponse(
	              responseCode = "500", 
	              description = "An unplanned error occurred.", 
	              content = @Content(
	                  mediaType = "application/json")) },
	 
	      parameters = {
	          @Parameter(
	              name = "foodName", 
	              allowEmptyValue = false, 
	              required = false, 
	              description = "The foodName (i.e., 'Spaghetti')")
	     }
	  )
	  //@formatter:on
	     
	 //This is what will return a list of customers 
	  @GetMapping 
	  @ResponseStatus(code = HttpStatus.OK)
	  List<Menu> fetchMenus(
	      @RequestParam(required = false)
	      String foodName); 

}
