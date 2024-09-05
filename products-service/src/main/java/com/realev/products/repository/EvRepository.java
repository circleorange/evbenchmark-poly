package com.realev.products.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.realev.products.model.EvEntity;

@Repository
public interface EvRepository 
		extends JpaRepository<EvEntity, Long> {

	// Custom queries if needed, most inherited from JPA
}

