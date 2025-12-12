package com.acuadrado.vetclinic.service;

import com.acuadrado.vetclinic.dto.PetDto;

import java.util.List;

public interface PetService {
    List<PetDto> findAll();
    PetDto create(PetDto petDto);
}
