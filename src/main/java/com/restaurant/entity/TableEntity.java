package com.restaurant.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="table_entity")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class TableEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="table_id")
	private Long tableId;
	@Column(name="table_name")
	private String tableName;
	@Column(name="seating_capacity")
	private int seatingCapacity;
	
	@ManyToOne
	@JoinColumn(name="restaurant_id")
	private RestaurantEntity restaurantEntity;

	public TableEntity() {
		
	}

	public TableEntity(Long tableId, String tableName, int seatingCapacity, RestaurantEntity restaurantEntity) {
		super();
		this.tableId = tableId;
		this.tableName = tableName;
		this.seatingCapacity = seatingCapacity;
		this.restaurantEntity = restaurantEntity;
	}

	public Long getTableId() {
		return tableId;
	}

	public void setTableId(Long tableId) {
		this.tableId = tableId;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public int getSeatingCapacity() {
		return seatingCapacity;
	}

	public void setSeatingCapacity(int seatingCapacity) {
		this.seatingCapacity = seatingCapacity;
	}

	public RestaurantEntity getRestaurantEntity() {
		return restaurantEntity;
	}

	public void setRestaurantEntity(RestaurantEntity restaurantEntity) {
		this.restaurantEntity = restaurantEntity;
	}
}
	