package com.acuadrado.vetclinic.service;

import com.acuadrado.vetclinic.dto.VisitDto;

import java.util.List;

public interface VisitService {
    List<VisitDto> findAll();
    VisitDto create(VisitDto visitDto);
}
