package com.realev.products.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.realev.products.dto.EvCreateRequest;
import com.realev.products.dto.EvUpdateRequest;
import com.realev.products.model.EvEntity;
import com.realev.products.repository.EvRepository;
import com.realev.products.storage.ImageStorageService;

@Service
public class EvService {

	@Autowired
	private EvRepository repo;

	@Autowired
	private ImageStorageService imgStorageServ;

	public EvEntity createEV(EvCreateRequest r) {
		var ev		= new EvEntity();
		ev.make		= r.make;
		ev.model	= r.model;
		ev.year		= r.year;
		ev.range	= r.range;
		ev.price	= r.price;

		// String imgUrl = imgStorageServ.storeImage(r.imageFile);
		// ev.imageUrl = imgUrl;

		return repo.save(ev);
	}

	public Optional<EvEntity> updateEV(Long id, EvUpdateRequest r) {
		Optional<EvEntity> existingEv = repo.findById(id);
		if (!existingEv.isPresent()) {
			return Optional.empty();
        }
		var ev = new EvEntity();
		ev.make	    = r.make;
		ev.model	= r.model;
		ev.year	    = r.year;
		ev.range	= r.range;
		ev.price	= r.price;

		if (r.imageFile == null) {
			return Optional.of(repo.save(ev));
		}
		String imgUrl = imgStorageServ.storeImage(r.imageFile);
		ev.imageUrl = imgUrl;

		return Optional.of(repo.save(ev));
	}

	public void deleteEV(Long ID) {
		repo.deleteById(ID);
	}
}
