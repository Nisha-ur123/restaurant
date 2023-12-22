package com.restaurant.repository;



import java.util.List;

//import java.time.LocalDate;
//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.BookingEntity;


@Repository
public interface BookingRepository extends JpaRepository <BookingEntity, Long> {

	@Query("SELECT t FROM BookingEntity t WHERE t.user.userId= :userId")
	List<BookingEntity> findAllBookingsByUsrId(@Param ("userId") Long userId);

	

	//boolean existsByInventroyIdAndMealType(Long inventroyId, String mealType);

	
}
