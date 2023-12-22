package com.restaurant.vo;

import java.time.LocalDate;

import com.fasterxml.jackson.annotation.JsonIgnore;


public class BookingVo {
	
	private Long bookingId;
	@JsonIgnore()
	private Long inventoryId;
	private String mealType;
	private String restaurantName;
	private  LocalDate bookingDate;
	private int numberOfPerson;
	private String bookingStatus;
	
	public BookingVo() {
		
	}

	public BookingVo(Long bookingId, Long inventoryId, String mealType, String restaurantName, LocalDate bookingDate,
			int numberOfPerson, String bookingStatus) {
		super();
		this.bookingId = bookingId;
        this.inventoryId = inventoryId;
		this.mealType = mealType;
		this.restaurantName = restaurantName;
		this.bookingDate = bookingDate;
		this.numberOfPerson = numberOfPerson;
		this.bookingStatus = bookingStatus;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public Long getInventoryId() {
		return inventoryId;
	}

	public void setInventoryId(Long inventoryId) {
		this.inventoryId = inventoryId;
	}

	public String getMealType() {
		return mealType;
	}

	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	public LocalDate getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(LocalDate bookingDate) {
		this.bookingDate = bookingDate;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

	public String getBookingStatus() {
		return bookingStatus;
	}

	public void setBookingStatus(String bookingStatus) {
		this.bookingStatus = bookingStatus;
	}

}
