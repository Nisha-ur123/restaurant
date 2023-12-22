package com.restaurant.vo;

public class BookMealVo {

	private int seatAvailability;
    private String mealType;
    
    public BookMealVo() {
    }

	public BookMealVo(int seatAvailability, String mealType) {
		super();
		this.seatAvailability = seatAvailability;
		this.mealType = mealType;
	}

	public int getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(int seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}
    
}

