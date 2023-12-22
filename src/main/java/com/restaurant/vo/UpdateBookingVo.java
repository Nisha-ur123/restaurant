package com.restaurant.vo;

public class UpdateBookingVo {
	
	private Long bookingId;
	private int numberOfPerson;
	
	public UpdateBookingVo()
	{
		
	}

	public UpdateBookingVo(Long bookingId, int numberOfPerson) {
		super();
		this.bookingId = bookingId;
		this.numberOfPerson = numberOfPerson;
	}

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public int getNumberOfPerson() {
		return numberOfPerson;
	}

	public void setNumberOfPerson(int numberOfPerson) {
		this.numberOfPerson = numberOfPerson;
	}

}
