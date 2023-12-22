package com.restaurant.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
//import org.springframework.data.jpa.repository.Query;
//import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.InventoryEntity;
import com.restaurant.entity.MealsEntity;
import com.restaurant.entity.TableEntity;

@Repository 
public interface InventoryRepository extends JpaRepository <InventoryEntity,Long>{

	List<InventoryEntity> findByInventoryDateBetween(LocalDate startDate, LocalDate endDate);

	//boolean existsByTableAndMeal(TableEntity table, MealsEntity meal);
	
//    List<InventoryEntity> findByInventoryDateBetweenAndMealType(LocalDate inventoryDate, List<String> mealType);
	}

//    @Query("SELECT t FROM InventoryEntity t WHERE t.inventoryEntity.inventoryDate = :inventoryDate,t.inventoryEntity.mealType = :mealType")
//	List<InventoryEntity> findByInventoryDateBetweenAndMealType(@Param("inventoryDate")LocalDate inventoryDate,@Param("mealType") String mealType);
  //  
