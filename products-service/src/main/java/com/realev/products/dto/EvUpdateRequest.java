package com.realev.products.dto;

import org.springframework.web.multipart.MultipartFile;

public class EvUpdateRequest {
	public String   make;
	public String   model;
	public Integer  year;
	public Integer  range;
	public Double   price;
	public MultipartFile imageFile;
}

