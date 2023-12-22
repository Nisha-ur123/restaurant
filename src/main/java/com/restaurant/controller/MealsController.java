package com.restaurant.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.MealsEntity;
import com.restaurant.service.MealsService;
@RestController
@RequestMapping("/admin")
public class MealsController {
	
@Autowired MealsService MealService;

@PostMapping("/addmeals")
public String addMeal(@RequestBody MealsEntity mealEntity)
{
	return MealService.addMeal(mealEntity);
}

@GetMapping("getallmeals")
public ResponseEntity<List<MealsEntity>> getAllMeals()
{
   List<MealsEntity> meals = MealService.getAllMeals();
   return ResponseEntity.ok(meals);
}

@DeleteMapping("/deletemeal/{meal_id}")	
public String DeleteMeal(@PathVariable Long meal_id)
{
	return MealService.deleteMeal(meal_id);
}
}

