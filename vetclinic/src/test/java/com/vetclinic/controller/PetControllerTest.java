package com.vetclinic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.vetclinic.dto.PetDTO;
import com.vetclinic.service.PetService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class PetControllerTest {

    private MockMvc mockMvc;

    @Mock
    private PetService petService;

    @InjectMocks
    private PetController petController;

    ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @BeforeEach
    void setUp() {
        org.mockito.MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(petController).build();
    }

    @Test
    void testGetAllPets() throws Exception {
        PetDTO pet1 = new PetDTO(1L, "Firulais", "Perro", LocalDate.of(2020, 5, 10), 1L);
        PetDTO pet2 = new PetDTO(2L, "Michi", "Gato", LocalDate.of(2019, 3, 15), 2L);

        when(petService.findAll()).thenReturn(List.of(pet1, pet2));

        mockMvc.perform(get("/pets"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].name").value("Firulais"))
                .andExpect(jsonPath("$[1].name").value("Michi"));
    }

    @Test
    void testGetPetById() throws Exception {
        PetDTO pet = new PetDTO(1L, "Firulais", "Perro", LocalDate.of(2020, 5, 10), 1L);

        when(petService.findById(1L)).thenReturn(Optional.of(pet));

        mockMvc.perform(get("/pets/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Firulais"));
    }

    @Test
    void testCreatePet() throws Exception {
        PetDTO pet = new PetDTO(null, "Firulais", "Perro", LocalDate.of(2020, 5, 10), 1L);
        PetDTO savedPet = new PetDTO(1L, "Firulais", "Gato", LocalDate.of(2020, 5, 10), 1L);

        when(petService.save(any(PetDTO.class))).thenReturn(savedPet);

        mockMvc.perform(post("/pets")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(pet)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.name").value("Firulais"));
    }

    @Test
    void testDeletePet() throws Exception {
        mockMvc.perform(delete("/pets/1"))
                .andExpect(status().isNoContent());
    }
}
