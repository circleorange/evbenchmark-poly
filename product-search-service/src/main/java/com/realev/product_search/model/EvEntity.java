package com.realev.product_search.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class EvEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long ID;

	public String	make;
	public String	model;
	public Integer	year;
	public Integer	range;
	public Double	price;
	public String	imageUrl;
}

