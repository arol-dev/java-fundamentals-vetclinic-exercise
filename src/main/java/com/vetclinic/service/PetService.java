package com.vetclinic.service;

import java.util.*;

import com.vetclinic.dto.*;

public interface PetService {
    List<PetDTO> findAll();

    PetDTO findById(Long id);

    PetDTO save(PetDTO d);

    void delete(Long id);
}