package com.vetclinic.service;

import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.repository.OwnerRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.modelmapper.ModelMapper;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class OwnerServiceTest {

    private OwnerRepository ownerRepository;
    private ModelMapper modelMapper;
    private OwnerService ownerService;

    @BeforeEach
    void setUp() {
        ownerRepository = mock(OwnerRepository.class);
        modelMapper = new ModelMapper();
        ownerService = new OwnerService(ownerRepository, modelMapper);
    }

    @Test
    void testSaveOwner() {
        OwnerDTO dto = new OwnerDTO();
        dto.setName("Juan");
        dto.setPhone("123456789");
        dto.setAddress("Calle A");

        Owner owner = modelMapper.map(dto, Owner.class);
        owner.setId(1L);

        when(ownerRepository.save(any(Owner.class))).thenReturn(owner);

        OwnerDTO saved = ownerService.save(dto);

        assertNotNull(saved);
        assertEquals("Juan", saved.getName());
        assertEquals("123456789", saved.getPhone());
        verify(ownerRepository, times(1)).save(any(Owner.class));
    }

    @Test
    void testFindByIdFound() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("Maria");
        owner.setPhone("987654321");

        when(ownerRepository.findById(1L)).thenReturn(Optional.of(owner));

        Optional<OwnerDTO> result = ownerService.findById(1L);

        assertTrue(result.isPresent());
        assertEquals("Maria", result.get().getName());
    }

    @Test
    void testFindByIdNotFound() {
        when(ownerRepository.findById(1L)).thenReturn(Optional.empty());

        Optional<OwnerDTO> result = ownerService.findById(1L);

        assertFalse(result.isPresent());
    }

    @Test
    void testFindAll() {
        Owner owner = new Owner();
        owner.setId(1L);
        owner.setName("Carlos");
        owner.setPhone("55555");

        when(ownerRepository.findAll()).thenReturn(List.of(owner));

        List<OwnerDTO> result = ownerService.findAll();

        assertEquals(1, result.size());
        assertEquals("Carlos", result.get(0).getName());
    }
}

