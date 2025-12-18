package com.example.vetclinic.servicies;

import com.example.vetclinic.dto.VisitDTO;

import java.util.List;

public interface VisitService {
  List<VisitDTO> getAll();

  VisitDTO create(VisitDTO visitDTO);
}