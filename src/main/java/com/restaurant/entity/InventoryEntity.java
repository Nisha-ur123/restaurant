package com.restaurant.entity;


import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table (name="inventory_entity")
public class InventoryEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="inventroy_id")
	private Long inventroyId;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "table_id")
	private TableEntity table;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name= "meal_id")
	private MealsEntity mealsEntity;
	
	@Column(name="inventory_date")
	private LocalDate inventoryDate;
	@Column(name="seat_availability")
	private int seatAvailability;
	
	public InventoryEntity() {
		
	}

	public Long getInventroyId() {
		return inventroyId;
	}

	public void setInventroyId(Long inventroyId) {
		this.inventroyId = inventroyId;
	}

	public TableEntity getTable() {
		return table;
	}

	public void setTable(TableEntity table) {
		this.table = table;
	}

	public MealsEntity getMealsEntity() {
		return mealsEntity;
	}

	public void setMealsEntity(MealsEntity mealsEntity) {
		this.mealsEntity = mealsEntity;
	}

	public LocalDate getInventoryDate() {
		return inventoryDate;
	}

	public void setInventoryDate(LocalDate inventoryDate) {
		this.inventoryDate = inventoryDate;
	}

	public int getSeatAvailability() {
		return seatAvailability;
	}

	public void setSeatAvailability(int seatAvailability) {
		this.seatAvailability = seatAvailability;
	}

}