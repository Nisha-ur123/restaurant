package com.restaurant.vo;

import java.time.LocalDate;



public class CheckAvailabilityVo {
	
	private LocalDate inventoryDate;
	private String mealType;
	
	public CheckAvailabilityVo()
	{
		
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
}
	