package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.RestaurantEntity;
import com.restaurant.service.RestaurantService;

@RestController
@RequestMapping("/admin")
public class RestaurantController {
	
	@Autowired
	private RestaurantService restaurantService;
	
	@PostMapping("/addrestaurant")
	public String addRestaurant(@RequestBody RestaurantEntity restaurantentity)
	{
		return restaurantService.addRestaurant(restaurantentity);
	}
	
    @GetMapping("/getallresturant")
    public ResponseEntity<List<RestaurantEntity>> getallRestaurant()
    {
    List<RestaurantEntity>restaurant =restaurantService.getallRestaurant();
    return ResponseEntity.ok(restaurant);
    }
    
     @DeleteMapping("/deleterestaurant/{reataurant_id}")
    public String deleteRestaurant(@PathVariable Long RestaurantId)
    {
    	return restaurantService.deleteRestaurant(RestaurantId);
    }
}