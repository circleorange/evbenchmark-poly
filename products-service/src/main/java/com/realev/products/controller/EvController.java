package com.realev.products.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.realev.products.dto.EvCreateRequest;
import com.realev.products.dto.EvUpdateRequest;
import com.realev.products.model.EvEntity;
import com.realev.products.service.EvService;

@RestController
@RequestMapping("/ev")
public class EvController {

	@Autowired
	private EvService serv;

	@PostMapping("/create")
	public ResponseEntity<EvEntity> createEV(@ModelAttribute EvCreateRequest r) {
		var createdEV = serv.createEV(r);
		return ResponseEntity.ok(createdEV);
	}

	@PutMapping("/update/{id}")
	public ResponseEntity<EvEntity> updateEV(
		@PathVariable Long ID,
		@ModelAttribute EvUpdateRequest r
	) {
		Optional<EvEntity> updatedEV = serv.updateEV(ID, r);
		return updatedEV
			.map(ResponseEntity::ok)
			.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Void> deleteEV(@PathVariable Long ID) {
		serv.deleteEV(ID);
		return ResponseEntity.noContent().build();
	}
}
