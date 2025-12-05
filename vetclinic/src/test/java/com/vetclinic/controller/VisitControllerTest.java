package com.vetclinic.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.vetclinic.dto.VisitDTO;
import com.vetclinic.service.VisitService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class VisitControllerTest {

    private MockMvc mockMvc;

    @Mock
    private VisitService visitService;

    @InjectMocks
    private VisitController visitController;

    ObjectMapper objectMapper = new ObjectMapper()
        .registerModule(new JavaTimeModule())
        .disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);

    @BeforeEach
    void setUp() {
        org.mockito.MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(visitController).build();
    }

    @Test
    void testGetAllVisits() throws Exception {
        VisitDTO visit1 = new VisitDTO(1L, LocalDate.of(2025, 1, 10), "Checkup", 1L);
        VisitDTO visit2 = new VisitDTO(2L, LocalDate.of(2025, 2, 15), "Vacuna", 2L);

        when(visitService.findAll()).thenReturn(List.of(visit1, visit2));

        mockMvc.perform(get("/visits"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()").value(2))
                .andExpect(jsonPath("$[0].reason").value("Checkup"))
                .andExpect(jsonPath("$[1].reason").value("Vacuna"));
    }

    @Test
    void testGetVisitById() throws Exception {
        VisitDTO visit = new VisitDTO(1L, LocalDate.of(2025, 1, 10), "Checkup", 1L);

        when(visitService.findById(1L)).thenReturn(Optional.of(visit));

        mockMvc.perform(get("/visits/1"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.reason").value("Checkup"));
    }

    @Test
    void testCreateVisit() throws Exception {
        VisitDTO visit = new VisitDTO(null, LocalDate.of(2025, 1, 10), "Checkup", 1L);
        VisitDTO savedVisit = new VisitDTO(1L, LocalDate.of(2025, 1, 10), "Checkup", 1L);

        when(visitService.save(any(VisitDTO.class))).thenReturn(savedVisit);

        mockMvc.perform(post("/visits")
                .contentType(MediaType.APPLICATION_JSON)
                .content(objectMapper.writeValueAsString(visit)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.id").value(1))
                .andExpect(jsonPath("$.reason").value("Checkup"));
    }

    @Test
    void testDeleteVisit() throws Exception {
        mockMvc.perform(delete("/visits/1"))
                .andExpect(status().isNoContent());
    }
}