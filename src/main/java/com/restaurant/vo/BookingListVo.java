package com.restaurant.vo;

public class BookingListVo {
	
	private Long userId;
	
	public BookingListVo()
	{
		
	}

	public BookingListVo(Long userId) {
		super();
		this.userId = userId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

}
