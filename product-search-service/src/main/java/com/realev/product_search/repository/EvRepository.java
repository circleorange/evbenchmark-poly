package com.realev.product_search.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realev.product_search.model.EvEntity;

@Repository
public interface EvRepository extends JpaRepository<EvEntity, Long> {

	List<EvEntity> findByMake(String make);
	List<EvEntity> findByModel(String model);
	List<EvEntity> findByYear(Integer year);
	List<EvEntity> findByRangeBetween(Integer minRange, Integer maxRange);
	List<EvEntity> findByPriceBetween(Double minPrice, Double maxPrice);
}

