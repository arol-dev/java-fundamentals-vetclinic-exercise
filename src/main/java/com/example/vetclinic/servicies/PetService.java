package com.example.vetclinic.servicies;


import com.example.vetclinic.dto.PetDTO;

import java.util.List;

public interface PetService {
  List<PetDTO> getAll();

  PetDTO create(Long ownerId, PetDTO petDTO);
}