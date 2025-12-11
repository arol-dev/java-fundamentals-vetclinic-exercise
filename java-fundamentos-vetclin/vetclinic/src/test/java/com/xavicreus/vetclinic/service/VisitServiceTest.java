package com.xavicreus.vetclinic.service;

import com.xavicreus.vetclinic.entity.Pet;
import com.xavicreus.vetclinic.entity.Visit;
import com.xavicreus.vetclinic.repository.VisitRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class VisitServiceTest {

    private VisitRepository visitRepository;
    private VisitService visitService;

    @BeforeEach
    void setUp() {
        visitRepository = Mockito.mock(VisitRepository.class);
        visitService = new VisitService(visitRepository);
    }

    @Test
    void testFindAll() {
        Visit visit = new Visit();
        visit.setMotivo("Vacunación");
        when(visitRepository.findAll()).thenReturn(List.of(visit));

        List<Visit> visits = visitService.findAll();

        assertNotNull(visits);
        assertEquals(1, visits.size());
        assertEquals("Vacunación", visits.get(0).getMotivo());
    }

    @Test
    void testSave() {
        Pet pet = new Pet();
        pet.setNombre("Rex");
        Visit visit = new Visit();
        visit.setFecha(LocalDate.now());
        visit.setMotivo("Chequeo");
        visit.setPet(pet);

        when(visitRepository.save(visit)).thenReturn(visit);

        Visit saved = visitService.save(visit);

        assertNotNull(saved);
        assertEquals("Chequeo", saved.getMotivo());
        assertEquals("Rex", saved.getPet().getNombre());
        verify(visitRepository, times(1)).save(visit);
    }
}
