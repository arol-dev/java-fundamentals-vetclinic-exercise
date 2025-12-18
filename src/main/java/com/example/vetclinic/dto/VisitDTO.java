package com.example.vetclinic.dto;

import java.time.LocalDate;

public record VisitDTO(Long id, LocalDate date, String reason, Long petId) {}
