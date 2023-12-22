 package com.restaurant.controller;



import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
//import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.restaurant.entity.TableEntity;
import com.restaurant.entity.UserEntity;
import com.restaurant.repository.UserRepository;
//import com.restaurant.repository.TableRepository;
import com.restaurant.service.TableService;
import com.restaurant.vo.TableVO;

@RestController
@RequestMapping("/admin")
public class TableController {
	
@Autowired
public TableService tableService;
@Autowired
public UserRepository userRepository;

@PostMapping("/addtable")
public String addTable(@RequestHeader ("userId") Long userId,@RequestBody TableVO tableVO)
{
	Optional<UserEntity> optionalUser = userRepository.findById(userId);
	if (optionalUser.isPresent())
	{
	UserEntity user = optionalUser.get();
	if(user.isAdmin())
	{
	return tableService.addTable(tableVO);
	}
	else
	{
	return ("Access denied. User is not an admin");
}
	
	}
	return ("user not found");
}


@GetMapping("getAllTables")
public ResponseEntity<List<TableEntity>> getAllTables()
{
    List<TableEntity> tables = tableService.getAllTables();
     return ResponseEntity.ok(tables);
}


@PutMapping("/updatetable/{tableId}")

public ResponseEntity<String> updateTableField(@RequestHeader ("userId") Long userId, @PathVariable Long tableId,@RequestParam(required=false) String tableName,@RequestParam(required = false) int seatingCapacity)
{
	UserEntity user =userRepository.findById(userId).orElse(null);
	if (user != null && user.isAdmin())
 {
	String updatedEvent =tableService.updateTableField(tableId, tableName, seatingCapacity);
	if(updatedEvent !=null) {
		return ResponseEntity.ok(updatedEvent);
	}else {
		return ResponseEntity.notFound().build();
		}
	}else
	{
		return ResponseEntity.status(HttpStatus.FORBIDDEN).body("Access denied. User is not an admin or invalid user");
	}
}


@DeleteMapping("/deletetable/{tableId}")
public String deleteTable(@RequestHeader ("userId") Long userId,@PathVariable Long tableId)
{
	Optional<UserEntity> optionalUser = userRepository.findById(userId);
	if (optionalUser.isPresent())
	{
	UserEntity user = optionalUser.get();
	if(user.isAdmin())
	{
	return tableService.deleteTable(tableId);
	}
	else
	{
	return ("Access denied. User is not an admin");
}
	
	}
	return ("user not found");
}
}


