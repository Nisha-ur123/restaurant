package com.restaurant.dao.impl;

import java.time.LocalDate;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.restaurant.dao.InventoryDao;


import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;

@Repository
public class InventoryDaoImpl implements InventoryDao{
	
	@PersistenceContext
	private EntityManager entityManager;
	
	@SuppressWarnings("unchecked")
	
	public List<Object[]>findByInventoryDateBetweenAndMealType(LocalDate inventoryDate, String mealType)
	{
		String queryString="SELECT meals.meal_type, inventory.seat_availability, inventory.inventory_date, inventory.inventroy_id,restaurant.restaurant_name,tab.table_name FROM inventory_entity inventory JOIN "
		+ "meals_entity meals ON meals.meal_id = inventory.meal_id JOIN"
		+ " table_entity tab ON tab.table_id = inventory.table_id JOIN"
		+ " restaurant_entity restaurant ON restaurant.restaurant_id = tab.restaurant_id WHERE meals.meal_type = :mealType AND inventory.inventory_date = :inventorydate";	
		Query query =entityManager.createNativeQuery(queryString);	
	    query.setParameter("mealType", mealType);
		query.setParameter("inventorydate", inventoryDate);
		return query.getResultList();
	}
}

//String queryString = "SELECT meal.meal_type,inventory.seat_availability, inventory.inventory_date,restaurant.restaurant_name FROM meals_entity meal JOIN "
//+ "inventory_entity inventory ON meal.meal_id = inventory.meal_id WHERE meal.meal_type = :mealType and inventory.inventory_date = :inventorydate and inventory.seat_availability = :seatAvailability";