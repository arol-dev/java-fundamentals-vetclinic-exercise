package com.acuadrado.vetclinic.service;

import com.acuadrado.vetclinic.dto.OwnerDto;

import java.util.List;

public interface OwnerService {
    List<OwnerDto> findAll();
    OwnerDto create(OwnerDto ownerDto);
}
