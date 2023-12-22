package com.restaurant.dao;

import java.time.LocalDate;
import java.util.List;



public interface InventoryDao {

	List<Object[]> findByInventoryDateBetweenAndMealType(LocalDate inventoryDate, String mealType);

}
