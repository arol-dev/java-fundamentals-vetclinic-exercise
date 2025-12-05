package com.vetclinic.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.Optional;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.service.OwnerService;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

@WebMvcTest(OwnerController.class)
public class OwnerControllerTest {

    @Autowired
    private MockMvc mockMvc;

    private OwnerService ownerService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void testGetAllOwners() throws Exception {
        OwnerDTO owner1 = new OwnerDTO(1L, "Alice", "123456789", "Calle 1");
        OwnerDTO owner2 = new OwnerDTO(2L, "Bob", "987654321", "Calle 2");

        when(ownerService.findAll()).thenReturn(Arrays.asList(owner1, owner2));

        mockMvc.perform(get("/owners"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$[0].name").value("Alice"))
               .andExpect(jsonPath("$[1].name").value("Bob"));
    }

    @Test
    void testGetOwnerById_Found() throws Exception {
        OwnerDTO owner = new OwnerDTO(1L, "Alice", "123456789", "Calle 1");
        when(ownerService.findById(1L)).thenReturn(Optional.of(owner));

        mockMvc.perform(get("/owners/1"))
               .andExpect(status().isOk())
               .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    void testGetOwnerById_NotFound() throws Exception {
        when(ownerService.findById(1L)).thenReturn(Optional.empty());

        mockMvc.perform(get("/owners/1"))
               .andExpect(status().isNotFound());
    }

    @Test
    void testCreateOwner() throws Exception {
        OwnerDTO owner = new OwnerDTO(null, "Alice", "123456789", "Calle 1");
        OwnerDTO savedOwner = new OwnerDTO(1L, "Alice", "123456789", "Calle 1");

        when(ownerService.save(any(OwnerDTO.class))).thenReturn(savedOwner);
    
        mockMvc.perform(post("/owners")
            .contentType(MediaType.APPLICATION_JSON)
            .content(objectMapper.writeValueAsString(owner)))
        .andExpect(status().isOk())
        .andExpect(jsonPath("$.id").value(1))
        .andExpect(jsonPath("$.name").value("Alice"));
    }

    @Test
    void testDeleteOwner() throws Exception {
        doNothing().when(ownerService).deleteById(1L);

        mockMvc.perform(delete("/owners/1"))
               .andExpect(status().isNoContent());
    }
}