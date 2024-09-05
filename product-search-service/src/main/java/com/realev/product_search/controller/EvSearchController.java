package com.realev.product_search.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.realev.product_search.model.EvEntity;
import com.realev.product_search.service.EvSearchService;

@RestController
public class EvSearchController {

	@Autowired
	private EvSearchService searchServ;

	@GetMapping("/ev/search/make")
	public List<EvEntity> searchByMake(@RequestParam String make) {
		return searchServ.searchByMake(make);
	}

	@GetMapping("/ev/search/model")
	public List<EvEntity> searchByModel(@RequestParam String model) {
		return searchServ.searchByModel(model);
	}

	@GetMapping("/ev/search/year")
	public List<EvEntity> searchByYear(@RequestParam Integer year) {
		return searchServ.searchByYear(year);
	}

	@GetMapping("/ev/search/range")
	public List<EvEntity> searchByRange(@RequestParam Integer minRange, @RequestParam Integer maxRange) {
		return searchServ.searchByRange(minRange, maxRange);
	}

	@GetMapping("/ev/search/price")
	public List<EvEntity> searchByPrice(@RequestParam Double minPrice, @RequestParam Double maxPrice) {
		return searchServ.searchByPrice(minPrice, maxPrice);
	}
}

