package com.restaurant.repository;




import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
//import org.springframework.stereotype.Repository;

import com.restaurant.entity.TableEntity;
//import com.restaurant.vo.TableVO;


public interface TableRepository extends  JpaRepository <TableEntity,Long>{

	@Query("SELECT t FROM TableEntity t WHERE t.restaurantEntity.restaurantId = :restaurantId")
	List<TableEntity> findByRestaurantId(@Param("restaurantId") int restaurantId);

	 Optional<TableEntity> findById(Long tableId);
 	
}
