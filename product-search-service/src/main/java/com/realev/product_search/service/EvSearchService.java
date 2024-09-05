package com.realev.product_search.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.realev.product_search.model.EvEntity;
import com.realev.product_search.repository.EvRepository;

@Repository
public class EvSearchService {

	@Autowired
	private EvRepository repo;

	public List<EvEntity> searchByMake(String make) {
		return repo.findByMake(make);
	}

	public List<EvEntity> searchByModel(String model) {
		return repo.findByModel(model);
	}

	public List<EvEntity> searchByYear(Integer year) {
		return repo.findByYear(year);
	}

	public List<EvEntity> searchByRange(Integer minRange, Integer maxRange) {
		return repo.findByRangeBetween(minRange, maxRange);
	}

	public List<EvEntity> searchByPrice(Double minPrice, Double maxPrice) {
		return repo.findByPriceBetween(minPrice, maxPrice);
	}
}
