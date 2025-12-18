package com.example.vetclinic.dto;

import java.time.LocalDate;

public record PetDTO(Long id, String name, String type, LocalDate birthDate) {}
