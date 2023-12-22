package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.RestaurantEntity;
import com.restaurant.repository.RestaurantRepository;

@Service
public class RestaurantService {
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
    public RestaurantService(RestaurantRepository restaurantRepository) {
		super();
		this.restaurantRepository = restaurantRepository;
	}

    public String addRestaurant(RestaurantEntity restaurant) 
    {
		restaurantRepository.save(restaurant);
		return "restaurant added successfully";
		
	}

	public List <RestaurantEntity> getallRestaurant() 
	{
		return restaurantRepository.findAll();
	}

//	public void updateRestaurant(Long restaurant_id, RestaurantEntity updateRestaurant)
//	{
//		restaurantrepository.findById(restaurant_id).ifPresent(restaurant -> {
//		restaurant.setRestaurant_name(updateRestaurant.getRestaurant_name());
//	restaurantrepository.save(restaurant);
//	});
//	}

	public String deleteRestaurant(Long RestaurantId) 
	{
		restaurantRepository.deleteById(RestaurantId);
		return "delete restaurant successfully";
	}

	
	}


