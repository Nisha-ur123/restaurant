package com.restaurant.controller;









import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.restaurant.service.InventoryService;

import com.restaurant.vo.InventoryVo;


@RestController
@RequestMapping("/admin")
public class InventoryController {
	
	@Autowired 
	private InventoryService inventoryService;
	
@PostMapping("/addInventory")
	public ResponseEntity<String> createInventory(@RequestBody InventoryVo inventoryVo)
	{
		inventoryService.createInventory(inventoryVo);
		return ResponseEntity.ok("Inventory Added successfully");
	}

}
	
	
	
	
	
	



