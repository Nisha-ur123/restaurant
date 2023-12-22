package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.RestaurantEntity;
@Repository
public interface RestaurantRepository extends JpaRepository<RestaurantEntity ,Long> {
	@Query("SELECT r FROM RestaurantEntity r WHERE r.restaurantName = :restaurantName")
	RestaurantEntity findByRestaurantName(String restaurantName);

}



