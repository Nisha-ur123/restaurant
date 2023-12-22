package com.restaurant.service;

import java.time.LocalDate;

//import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.restaurant.entity.InventoryEntity;
import com.restaurant.entity.MealsEntity;
import com.restaurant.entity.TableEntity;
import com.restaurant.repository.InventoryRepository;
import com.restaurant.repository.MealsRepository;
import com.restaurant.repository.TableRepository;

import com.restaurant.vo.InventoryVo;

@Service
public class InventoryService {
	
	@Autowired
	private InventoryRepository inventoryRepository;	
	@Autowired
	private TableRepository tableRepository;
	@Autowired
	private MealsRepository mealsRepository;
	private Long inventroyId;
	
	
	public InventoryService(InventoryRepository inventoryRepository, TableRepository tableRepository,
			MealsRepository mealsRepository) {
		super();
		this.inventoryRepository = inventoryRepository;
		this.tableRepository = tableRepository;
		this.mealsRepository = mealsRepository;
	}

	public void createInventory(InventoryVo inventoryVo) 
	{
        Optional<InventoryEntity> inventory = inventoryRepository.findById(inventroyId);		
	   // List<LocalDate> InvenDates = (List<LocalDate>) inventory.get();
		if (inventory.isPresent()) 
		{
			System.out.println("already exit");
		}
		else
	      {
		final LocalDate startDate = inventoryVo.getStartDate();
		final LocalDate endDate = inventoryVo.getEndDate();
		
		List<TableEntity>tables = tableRepository.findAll();
		List<MealsEntity>meals = mealsRepository.findAll();
		for(LocalDate date= startDate; date.isBefore(endDate.plusDays(1)); date = date.plusDays(1))
      {
		for(TableEntity table : tables)
		{
			for(MealsEntity meal : meals)
				{

			 InventoryEntity inventoryEntity = new InventoryEntity();
		     inventoryEntity.setTable(table);
		     inventoryEntity.setMealsEntity(meal);
		     inventoryEntity.setInventoryDate(date);
		     inventoryEntity.setSeatAvailability(table.getSeatingCapacity());
	         inventoryRepository.save(inventoryEntity);
			}
			
		}
	}
}
		
	}
}
	



	
	
	

