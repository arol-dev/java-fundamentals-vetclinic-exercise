package com.xavicreus.vetclinic;

import com.xavicreus.vetclinic.entity.Owner;
import com.xavicreus.vetclinic.repository.OwnerRepository;
import com.xavicreus.vetclinic.service.OwnerService;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest {

    private OwnerRepository ownerRepository;
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        // Crear un mock del repositorio
        ownerRepository = Mockito.mock(OwnerRepository.class);
        ownerService = new OwnerService(ownerRepository);
    }

    @Test
    void testFindAll() {
        Owner owner = new Owner();
        owner.setNombre("Juan");
        when(ownerRepository.findAll()).thenReturn(List.of(owner));

        List<Owner> owners = ownerService.findAll();

        assertNotNull(owners);
        assertEquals(1, owners.size());
        assertEquals("Juan", owners.get(0).getNombre());
    }

    @Test
    void testSave() {
        Owner owner = new Owner();
        owner.setNombre("Maria");

        when(ownerRepository.save(owner)).thenReturn(owner);

        Owner saved = ownerService.save(owner);

        assertNotNull(saved);
        assertEquals("Maria", saved.getNombre());
        verify(ownerRepository, times(1)).save(owner);
    }

    @Test
    void testDeleteById() {
        doNothing().when(ownerRepository).deleteById(1L);

        ownerService.deleteById(1L);

        verify(ownerRepository, times(1)).deleteById(1L);
    }

    @Test
    void testFindById() {
        Owner owner = new Owner();
        owner.setNombre("Pedro");
        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));

        Optional<Owner> found = ownerService.findById(1L);

        assertTrue(found.isPresent());
        assertEquals("Pedro", found.get().getNombre());
    }
}
