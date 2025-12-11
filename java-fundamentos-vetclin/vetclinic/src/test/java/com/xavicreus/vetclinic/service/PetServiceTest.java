package com.xavicreus.vetclinic.service;

import com.xavicreus.vetclinic.entity.Owner;
import com.xavicreus.vetclinic.entity.Pet;
import com.xavicreus.vetclinic.repository.PetRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class PetServiceTest {

    private PetRepository petRepository;
    private PetService petService;

    @BeforeEach
    void setUp() {
        petRepository = Mockito.mock(PetRepository.class);
        petService = new PetService(petRepository);
    }

    @Test
    void testFindAll() {
        Pet pet = new Pet();
        pet.setNombre("Firulais");
        when(petRepository.findAll()).thenReturn(List.of(pet));

        List<Pet> pets = petService.findAll();

        assertNotNull(pets);
        assertEquals(1, pets.size());
        assertEquals("Firulais", pets.get(0).getNombre());
    }

    @Test
    void testSave() {
        Owner owner = new Owner();
        owner.setNombre("Juan");
        Pet pet = new Pet();
        pet.setNombre("Max");
        pet.setTipo("Perro");
        pet.setFechaNacimiento(LocalDate.now());
        pet.setOwner(owner);

        when(petRepository.save(pet)).thenReturn(pet);

        Pet saved = petService.save(pet);

        assertNotNull(saved);
        assertEquals("Max", saved.getNombre());
        assertEquals("Perro", saved.getTipo());
        assertEquals("Juan", saved.getOwner().getNombre());
        verify(petRepository, times(1)).save(pet);
    }

    @Test
    void testFindById() {
        Pet pet = new Pet();
        pet.setNombre("Luna");
        when(petRepository.findById(1L)).thenReturn(Optional.of(pet));

        Optional<Pet> found = petService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("Luna", found.get().getNombre());
    }
}
