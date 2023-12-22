package com.restaurant.controller;

import java.time.LocalDate;
import java.util.List;

import javax.management.relation.RelationNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.restaurant.dao.InventoryDao;
import com.restaurant.entity.BookingEntity;

import com.restaurant.repository.BookingRepository;
import com.restaurant.repository.InventoryRepository;
import com.restaurant.service.BookingService;
import com.restaurant.vo.AvailableSlotVo;

import com.restaurant.vo.BookingRequestVo;
import com.restaurant.vo.BookingVo;
import com.restaurant.vo.CheckAvailabilityVo;
import com.restaurant.vo.UpdateBookingVo;

@RestController
@RequestMapping("/admin")
public class BookingController {

	@Autowired
	private BookingService bookingService;
	@Autowired
	public InventoryDao inventoryDao;
	@Autowired
	public InventoryRepository inventoryRepository;
	@Autowired
	public BookingRepository bookingRepository;

	@GetMapping("/availability")
	public ResponseEntity<List<AvailableSlotVo>> getByDateBetweenAndMealType(
			@RequestBody CheckAvailabilityVo availability) throws RelationNotFoundException {

		LocalDate inventoryDate = availability.getInventoryDate();
		String mealType = availability.getMealType();
		return ResponseEntity.ok(bookingService.getByDateBetweenAndMealType(inventoryDate, mealType));

	}

	// create booking
//	@PostMapping("/addbooking")
//	public ResponseEntity<String> createBooking(@RequestHeader ("userId") Long userId,@RequestBody BookingRequestVo bookVO) {
//		InventoryEntity in = inventoryRepository.findById(bookVO.getInventroyId()).get();
//
//		if (in != null && bookVO.getNumberOfPerson() <= in.getSeatAvailability()) {
//            bookVO.setUserId(userId);
//			bookingService.createBooking(bookVO);
//			return ResponseEntity.ok("booking successfully");
//
//		} else {
//			return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Booking not be done");
//		}
//	}
    @PostMapping("/addbooking") 
    public ResponseEntity<BookingEntity> createBooking(@RequestHeader ("userId") Long userId,@RequestBody BookingRequestVo bookVO) {
    	BookingEntity newBooking = bookingService.createBooking(bookVO);
    	{
    		if(newBooking != null) {
    			return ResponseEntity.ok(newBooking);
    		}else {
    			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
            }
        }
    		}
    	
	@GetMapping("/getbookings")
	public List<BookingVo>getAllBookingsByAccountsid(@RequestHeader ("userId") Long userId)
	{
		
		return bookingService.getAllBookingsByAccountsid(userId);
	}
	
	@PutMapping("/update")
	public ResponseEntity<String> updateBooking(@RequestHeader ("userId") Long userId,@RequestBody UpdateBookingVo updateBookingVo )
	{
		return bookingService.updateBooking(updateBookingVo);
	}
	
	@PutMapping("/deletebooking/{bookingId}")
	public ResponseEntity<String> cancelBooking (@PathVariable Long bookingId)
	{
		return bookingService.cancelBooking(bookingId);
	}
	}
	

