package com.restaurant.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.restaurant.entity.MealsEntity;
@Repository
public interface MealsRepository extends JpaRepository<MealsEntity, Long>{

}
