package com.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="meals_entity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class MealsEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="meal_id")
	private Long mealId ;
	
	@Column(name="meal_type")
	private String mealType;
	
	public MealsEntity() {
		
	}

	public Long getMealId() {
		return mealId;
	}

	public void setMealId(Long mealId) {
		this.mealId = mealId;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	
	
	
	


}
