package com.restaurant.entity;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import jakarta.persistence.Table;

@Entity
@Table(name="restaurant_entity")
public class RestaurantEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="restaurant_id")
	private Long restaurantId;
	@Column(name="restaurant_name")
	private String restaurantName;
	
	//@OneToMany(mappedBy ="restaurant",cascade= CascadeType.ALL)
	//private List<TableEntity> tables;
	
	public RestaurantEntity() {
		
	}

	public RestaurantEntity(Long restaurantId, String restaurantName, List<TableEntity> tables) {
		super();
		this.restaurantId = restaurantId;
		this.restaurantName = restaurantName;
		//this.tables = tables;
	}

	public Long getRestaurantId() {
		return restaurantId;
	}

	public void setRestaurantId(Long restaurantId) {
		this.restaurantId = restaurantId;
	}

	public String getRestaurantName() {
		return restaurantName;
	}

	public void setRestaurantName(String restaurantName) {
		this.restaurantName = restaurantName;
	}

	//public List<TableEntity> getTables() {
	//	return tables;
	//}

	//public void setTables(List<TableEntity> tables) {
	//	this.tables = tables;
	//}
}
	