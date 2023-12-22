package com.restaurant.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.restaurant.entity.MealsEntity;
import com.restaurant.repository.MealsRepository;

@Service
public class MealsService {
	
	@Autowired
	private MealsRepository mealsrepository;
	
	public MealsService(MealsRepository mealsrepository) {
		super();
		this.mealsrepository = mealsrepository;
	}

  public String addMeal(MealsEntity mealEntity) 
	{
		mealsrepository.save(mealEntity);
		return "meals added successfully";
	}
  
  public List<MealsEntity> getAllMeals() {
		
		return mealsrepository.findAll();
	}

public String deleteMeal(Long meal_id) 
{
	mealsrepository.deleteById(meal_id);
	return "delete meals successfully";
}


}
