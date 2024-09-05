package com.realev.products;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import org.mockito.MockitoAnnotations;

import com.realev.products.dto.EvCreateRequest;
import com.realev.products.dto.EvUpdateRequest;
import com.realev.products.model.EvEntity;
import com.realev.products.repository.EvRepository;
import com.realev.products.service.EvService;

class EvServiceTests {

	@Mock
	private EvRepository repo;

	@InjectMocks
	private EvService serv;

	@BeforeEach
	void setUp() {
		MockitoAnnotations.openMocks(this);
	}

	@Test
	void createEV() {
		// Mocking request object
		var request = new EvCreateRequest();
		request.make	= "Tesla";
		request.model	= "Model S";
		request.year	= 2021;
		request.range	= 400;
		request.price	= 25000.00;

		// Mocking returned entity
		var ev = new EvEntity();
        ev.ID       = 1L;
		ev.make		= "Tesla";
		ev.model	= "Model S";
		ev.year		= 2021;
		ev.range	= 400;
		ev.price	= 25000.00;

		when(repo.save(any(EvEntity.class)))
            .thenReturn(ev);

		var createdEV = serv.createEV(request);
		assertNotNull(createdEV);
		assertEquals("Tesla", createdEV.make);
        assertEquals("Model S", createdEV.model);
		assertEquals(2021, createdEV.year);
        assertEquals(400, createdEV.range);
		assertEquals(25000.00, createdEV.price);
	}

    @Test
    void updateEV() {
        var existingEv = new EvEntity();
        existingEv.ID       = 1L;
        existingEv.make	    = "Tesla";
		existingEv.model	= "Model 3";
		existingEv.year	    = 2019;
		existingEv.range	= 350;
		existingEv.price	= 22000.00;

        when(repo.findById(1L))
            .thenReturn(Optional.of(existingEv));

        when(repo.save(any(EvEntity.class)))
            .thenReturn(existingEv);

        var request = new EvUpdateRequest();
		request.make	= "Tesla";
		request.model	= "Model 3";
		request.year	= 2021;
		request.range	= 410;
		request.price	= 25000.00;

        var updatedEvEntity = new EvEntity();
        updatedEvEntity.ID = 1L;
        updatedEvEntity.make  = request.make;
        updatedEvEntity.model = request.model;
        updatedEvEntity.year  = request.year;
        updatedEvEntity.range = request.range;
        updatedEvEntity.price = request.price;

        when(repo.save(any(EvEntity.class)))
            .thenReturn(updatedEvEntity);

        var updatedEV = serv
            .updateEV(1L, request)
            .orElse(null);

        assertNotNull(updatedEV);
        assertEquals("Tesla", updatedEV.make);
        assertEquals("Model 3", updatedEV.model);
        assertEquals(2021, updatedEV.year);
        assertEquals(410, updatedEV.range);
        assertEquals(25000.00, updatedEV.price);
    }

    @Test
    void deleteEV() {
        doNothing()
            .when(repo)
            .deleteById(1L);
        
        serv.deleteEV(1L);
        verify(repo, times(1)).deleteById(1L);
    }

}
