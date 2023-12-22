package com.restaurant.service;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

//import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.restaurant.dao.InventoryDao;
import com.restaurant.entity.BookingEntity;
import com.restaurant.entity.InventoryEntity;
import com.restaurant.entity.UserEntity;
import com.restaurant.repository.BookingRepository;
import com.restaurant.repository.InventoryRepository;
import com.restaurant.repository.UserRepository;
import com.restaurant.vo.AvailableSlotVo;

import com.restaurant.vo.BookingRequestVo;
import com.restaurant.vo.BookingVo;
import com.restaurant.vo.UpdateBookingVo;

@Service
public class BookingService {
	@Autowired
	public InventoryRepository inventoryRepository;
	@Autowired
	public BookingRepository bookingRepository;

	@Autowired
	private InventoryDao inventoryDao;
	@Autowired
	public UserRepository userRepository;

	// checkAvailability
	public List<AvailableSlotVo> getByDateBetweenAndMealType(LocalDate inventoryDate, String mealType) {
		List<Object[]> resultList = inventoryDao.findByInventoryDateBetweenAndMealType(inventoryDate, mealType);
		List<AvailableSlotVo> availSlot = new ArrayList<AvailableSlotVo>();
		for (Object[] result : resultList) {
			AvailableSlotVo availableSlotVo = new AvailableSlotVo();
			DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
			LocalDate date = LocalDate.parse(result[2].toString(), formatter);
			availableSlotVo.setInventoryDate(date);
			availableSlotVo.setMealType(result[0].toString());
			availableSlotVo.setSeatAvailability(result[1].toString());
			availableSlotVo.setInventroyId(result[3].toString());
			availableSlotVo.setRestaurantName(result[4].toString());
			availableSlotVo.setTableName(result[5].toString());
			availSlot.add(availableSlotVo);
		}
		return availSlot;
	}

//createbooking
//
//	public BookingEntity createBooking(BookingRequestVo bookVO) {
//		BookingEntity book = new BookingEntity();
//		InventoryEntity in = inventoryRepository.findById(bookVO.getInventroyId()).get();
//		if (in.getSeatAvailability() >= bookVO.getNumberOfPerson()) {
//			in.setSeatAvailability(in.getSeatAvailability() - bookVO.getNumberOfPerson());
//			book.setInventroy(in);
//			UserEntity user = userRepository.findById(bookVO.getUserId()).get();
//			book.setUser(user);
//			book.setBookingDate(bookVO.getBookingDate());
//			book.setNumberOfPerson(bookVO.getNumberOfPerson());
//			book.setBookingStatus("Confirmed");
//		}
//		return bookingRepository.save(book);
//	}
	@SuppressWarnings("unlikely-arg-type")
	public BookingEntity createBooking(BookingRequestVo bookVO)
	{
		BookingEntity book = null;
		InventoryEntity in = inventoryRepository.findById(bookVO.getInventroyId()).orElse(null);
	   
		if(in != null && in.getSeatAvailability()>= bookVO.getNumberOfPerson()&& in.getMealsEntity().getMealType().equals(bookVO.getMealType()))
		{
			 book = new BookingEntity();
			in.setSeatAvailability(in.getSeatAvailability() - bookVO.getNumberOfPerson());
		    System.out.println("already booked");
		    book.setInventroy(in);
		    
		    UserEntity user = userRepository.findById(bookVO.getUserId()).orElse(null);
		    
		    if(user != null) {
		    	
		    	book.setUser(user);
		    	book.setBookingDate(bookVO.getBookingDate());
		    	book.setNumberOfPerson(bookVO.getNumberOfPerson());
		    	book.setBookingStatus("confirmed");
		    	return bookingRepository.save(book);
		    }
		}
	return book;
}
//	 
	// getbooking

	public List<BookingVo> getAllBookingsByAccountsid(Long userId) {
		List<BookingEntity> bookings = bookingRepository.findAllBookingsByUsrId(userId);
		List<BookingVo> bookingVOs = new ArrayList<BookingVo>();
		for (BookingEntity booking : bookings) {
			BookingVo bookingVO = new BookingVo();
			bookingVO.setBookingId(booking.getBookingId());
			bookingVO.setMealType(booking.getInventroy().getMealsEntity().getMealType());
			bookingVO.setRestaurantName(booking.getInventroy().getTable().getTableName());
			bookingVO.setBookingDate(booking.getBookingDate());
			bookingVO.setNumberOfPerson(booking.getNumberOfPerson());
			bookingVO.setBookingStatus(booking.getBookingStatus());
			bookingVOs.add(bookingVO);
		}
		return bookingVOs;
	}

	// add more persons

	public ResponseEntity<String> updateBooking(UpdateBookingVo updateBookingVo) {
		BookingEntity bookingEn = bookingRepository.findById(updateBookingVo.getBookingId()).get();

	
		InventoryEntity in = bookingEn.getInventroy();
        if(in.getSeatAvailability() == 0)
        {
        	return ResponseEntity.ok("no seat available");
        }
		//int difference = updateBookingVo.getNumberOfPerson() - bookingEn.getNumberOfPerson();
		int updatedSeatAvailability = in.getSeatAvailability() - updateBookingVo.getNumberOfPerson();
        
		in.setSeatAvailability(updatedSeatAvailability);
		bookingEn.setNumberOfPerson(bookingEn.getNumberOfPerson()+ updateBookingVo.getNumberOfPerson() );
		

		bookingRepository.save(bookingEn);
		inventoryRepository.save(in);

		return ResponseEntity.ok("Booking and Inventory updated successfully");

	}
        

	public ResponseEntity<String> cancelBooking(Long bookingId) 
	{
		Optional<BookingEntity> optionalBooking = bookingRepository.findById(bookingId);
	    if(optionalBooking.isPresent())
	    {
	    	BookingEntity booking = optionalBooking.get();
	    	int cancelledSeats = booking.getNumberOfPerson();
	    	booking.setBookingStatus("cancelled");
	        bookingRepository.save(booking);
	        InventoryEntity inventory = booking.getInventroy();
	        inventory.setSeatAvailability(inventory.getSeatAvailability()+ cancelledSeats);
	        inventoryRepository.save(inventory);
	        return ResponseEntity.ok("Booking cancelled successfully");
	    }else
	    {
	    	return ResponseEntity.notFound().build();
	    }
	}



	
}
////seat booking
//	public String bookSeatForMealType(Long tableId,BookMealVo bookMealVo)
//	{
//		BookMealVo existingBooking = bookingRepository.findById(tableId).orElse(new BookMealVo());
//	  if (existingBooking.setSeatAvailability())
//	{
//		if(existingBooking.getMealType()== null ||existingBooking.getMealType().equals(bookMealVo.getMealType())); 
//		{
//	     existingBooking.setSeatAvailability();
//	     existingBooking.setMealType(bookMealVo.getMealType());
//	    
//         bookingRepository.save(existingBooking);
//
//         return "Seat booked for meal type: " + bookMealVo.getMealType();
//     } 
//		else 
//		{
//         return "Seat is already booked for a different meal type";
//     }
//      else 
// {
//     return "Seat is not available";
// }
//}
//
//	}
//}
