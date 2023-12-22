package com.restaurant.vo;


public class TableVO
{
    private String tableName;
    private int seatingCapacity;
    private String restaurantName;
    
    public TableVO() {
    	
    }

	public TableVO(String tableName, int seatingCapacity, String restaurantName) {
		this.tableName = tableName;
		this.seatingCapacity = seatingCapacity;
		this.restaurantName = restaurantName;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}
    
}