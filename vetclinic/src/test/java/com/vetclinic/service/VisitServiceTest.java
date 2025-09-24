package com.vetclinic.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import com.vetclinic.dto.VisitDTO;
import com.vetclinic.model.Pet;
import com.vetclinic.model.Visit;
import com.vetclinic.repository.PetRepository;
import com.vetclinic.repository.VisitRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class VisitServiceTest {

    private VisitRepository visitRepository;
    private PetRepository petRepository;
    private VisitService visitService;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        visitRepository = mock(VisitRepository.class);
        petRepository = mock(PetRepository.class);
        visitService = new VisitService(visitRepository, petRepository);
        modelMapper = new ModelMapper();
    }

    @Test
    void testSaveVisit_Success() {
        // Preparar datos
        Pet pet = new Pet();
        pet.setId(1L);
        
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setDate(LocalDate.now());
        visitDTO.setReason("Consulta rutinaria");
        visitDTO.setPetId(1L);

        Visit visitEntity = modelMapper.map(visitDTO, Visit.class);
        visitEntity.setPet(pet);

        when(petRepository.existsById(1L)).thenReturn(true);
        when(visitRepository.save(any(Visit.class))).thenReturn(visitEntity);

        // Ejecutar
        VisitDTO savedDTO = visitService.save(visitDTO);

        // Verificar
        assertNotNull(savedDTO);
        assertEquals(visitDTO.getReason(), savedDTO.getReason());
        verify(visitRepository).save(any(Visit.class));
    }

    @Test
    void testSaveVisit_FutureDate_ShouldThrow() {
        VisitDTO visitDTO = new VisitDTO();
        visitDTO.setDate(LocalDate.now().plusDays(1));
        visitDTO.setReason("Consulta");
        visitDTO.setPetId(1L);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            visitService.save(visitDTO);
        });

        assertEquals("La fecha de la visita no puede ser futura", exception.getMessage());
    }

    @Test
    void testFindAllVisits() {
        Visit visit1 = new Visit();
        visit1.setId(1L);
        visit1.setReason("Consulta1");
        Visit visit2 = new Visit();
        visit2.setId(2L);
        visit2.setReason("Consulta2");

        when(visitRepository.findAll()).thenReturn(Arrays.asList(visit1, visit2));

        List<VisitDTO> visits = visitService.findAll();

        assertEquals(2, visits.size());
        assertEquals("Consulta1", visits.get(0).getReason());
        assertEquals("Consulta2", visits.get(1).getReason());
    }

    @Test
    void testFindById_Found() {
        Visit visit = new Visit();
        visit.setId(1L);
        visit.setReason("Consulta");

        when(visitRepository.findById(1L)).thenReturn(Optional.of(visit));

        Optional<VisitDTO> result = visitService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Consulta", result.get().getReason());
    }

    @Test
    void testFindById_NotFound() {
        when(visitRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<VisitDTO> result = visitService.findById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void testDeleteById_Success() {
        when(visitRepository.existsById(1L)).thenReturn(true);

        visitService.deleteById(1L);

        verify(visitRepository).deleteById(1L);
    }

    @Test
    void testDeleteById_NotFound() {
        when(visitRepository.existsById(1L)).thenReturn(false);

        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            visitService.deleteById(1L);
        });

        assertEquals("No existe una visita con id 1", exception.getMessage());
    }
}
