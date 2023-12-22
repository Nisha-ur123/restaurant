package com.restaurant.vo;

import java.time.LocalDate;

public class AvailableSlotVo {
	
	private String inventroyId;
	private LocalDate inventoryDate;
	private String seatAvailability;
	private String restaurantName;
	private String mealType;
	private String tableName;
	
	public AvailableSlotVo() {
		
	}

	public AvailableSlotVo(String inventroyId, LocalDate inventoryDate, String seatAvailability, String restaurantName,
			String mealType, String tableName) {
		super();
		this.inventroyId = inventroyId;
		this.inventoryDate = inventoryDate;
		this.seatAvailability = seatAvailability;
		this.restaurantName = restaurantName;
		this.mealType = mealType;
		this.tableName = tableName;
	}

	public String getInventroyId() {
		return inventroyId;
	}

	public void setInventroyId(String string) {
		this.inventroyId = string;
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public String getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(String string) {
		this.seatAvailability = string;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}
	

}
