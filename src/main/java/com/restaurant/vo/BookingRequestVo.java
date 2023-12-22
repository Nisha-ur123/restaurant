package com.restaurant.vo;

import java.time.LocalDate;

public class BookingRequestVo {
	
	private  Long bookingId;
	private Long inventroyId;
	private Long userId;
	private LocalDate bookingDate;
	private int numberOfPerson;
	private String mealType;
	
	
	public BookingRequestVo()
	{
	}


	public BookingRequestVo(Long bookingId, Long inventroyId, Long userId, LocalDate bookingDate, int numberOfPerson,
			String mealType) {
		super();
		this.bookingId = bookingId;
		this.inventroyId = inventroyId;
		this.userId = userId;
		this.bookingDate = bookingDate;
		this.numberOfPerson = numberOfPerson;
		this.mealType = mealType;
	}


	public Long getBookingId() {
		return bookingId;
	}


	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}


	public Long getInventroyId() {
		return inventroyId;
	}


	public void setInventroyId(Long inventroyId) {
		this.inventroyId = inventroyId;
	}


	public Long getUserId() {
		return userId;
	}


	public void setUserId(Long userId) {
		this.userId = userId;
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


	public String getMealType() {
		return mealType;
	}


	public void setMealType(String mealType) {
		this.mealType = mealType;
	}

}