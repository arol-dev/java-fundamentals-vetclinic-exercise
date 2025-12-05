package com.vetclinic.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.time.LocalDate;

import com.vetclinic.dto.PetDTO;
import com.vetclinic.model.Pet;
import com.vetclinic.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

class PetServiceTest {

    private PetRepository petRepository;
    private PetService petService;
    private ModelMapper modelMapper;

    @BeforeEach
    void setUp() {
        petRepository = mock(PetRepository.class);
        modelMapper = new ModelMapper();
        petService = new PetService(petRepository, modelMapper);
    }

    @Test
    void testSavePet_BirthDateInFuture_ThrowsException() {
        PetDTO petDTO = new PetDTO();
        petDTO.setName("Fido");
        petDTO.setBirthDate(LocalDate.now().plusDays(1));
        petDTO.setOwnerId(1L);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            petService.save(petDTO);
        });

        assertEquals("La fecha de nacimiento no puede ser del futuro", exception.getMessage());
    }

    @Test
    void testSavePet_WithValidData_CallsRepository() {
        PetDTO petDTO = new PetDTO();
        petDTO.setName("Fido");
        petDTO.setBirthDate(LocalDate.now().minusDays(1));
        petDTO.setOwnerId(1L);

        // Mockeamos la existencia del owner en la repo
        when(petRepository.existsById(anyLong())).thenReturn(true);
        when(petRepository.save(any(Pet.class))).thenAnswer(invocation -> invocation.getArgument(0));

        PetDTO saved = petService.save(petDTO);

        assertNotNull(saved);
        assertEquals("Fido", saved.getName());
        verify(petRepository, times(1)).save(any(Pet.class));
    }

    @Test
    void testDeletePetById_NonExisting_ThrowsException() {
        when(petRepository.existsById(1L)).thenReturn(false);

        IllegalArgumentException exception = assertThrows(IllegalArgumentException.class, () -> {
            petService.deleteById(1L);
        });

        assertEquals("No existe una mascota con id 1", exception.getMessage());
    }

    @Test
    void testDeletePetById_Existing_CallsRepository() {
        when(petRepository.existsById(1L)).thenReturn(true);
        doNothing().when(petRepository).deleteById(1L);

        petService.deleteById(1L);

        verify(petRepository, times(1)).deleteById(1L);
    }
}