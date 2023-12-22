package com.restaurant.service;



import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.restaurant.entity.RestaurantEntity;
import com.restaurant.entity.TableEntity;
import com.restaurant.repository.RestaurantRepository;
import com.restaurant.repository.TableRepository;
import com.restaurant.vo.TableVO;



@Service
public class TableService {
	
	@Autowired
	private TableRepository tableRepository;
	
	@Autowired
	private RestaurantRepository restaurantRepository;
	
	

	public TableService(TableRepository tableRepository, RestaurantRepository restaurantRepository) {
		super();
		this.tableRepository = tableRepository;
		this.restaurantRepository = restaurantRepository;
	}

    public String addTable(TableVO tableVO) 
	{
		RestaurantEntity restaurantEntity = restaurantRepository.findByRestaurantName(tableVO.getRestaurantName());

		 if (restaurantEntity == null)
		 {
			 return "invalid restaurant name";
		 }
	        
			 TableEntity tableEntity = new TableEntity();
			 
				tableEntity.setTableName(tableVO.getTableName());
				tableEntity.setSeatingCapacity(tableVO.getSeatingCapacity());
		        tableEntity.setRestaurantEntity(restaurantEntity);
				tableRepository.save(tableEntity);
		        return "table added successfully";
	 }

   public List<TableEntity> getAllTables() 
	   {
		return tableRepository.findAll();
	 }

	public String updateTableField(Long tableId, String tableName, int seatingCapacity) {
		{
		Optional<TableEntity> optionalTable =tableRepository.findById(tableId);
		if(optionalTable.isPresent())
		{
		TableEntity tableEntity =optionalTable.get();
		if(tableName != null && !tableName.isEmpty()) 
		{
		 tableEntity.setTableName(tableName);
		}
		if (seatingCapacity>0)
		{
			tableEntity.setSeatingCapacity(seatingCapacity);
		}
		tableRepository.save(tableEntity);
		return "updated successfully";
	}else
	{
		return "not found";
	}
	}}

public String deleteTable(Long tableId) 
	{
		tableRepository.deleteById(tableId);
		return "delete successfully";
	}

}	
