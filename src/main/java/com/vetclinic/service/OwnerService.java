package com.vetclinic.service;

import java.util.*;

import com.vetclinic.dto.*;

public interface OwnerService {
    List<OwnerDTO> findAll();

    OwnerDTO findById(Long id);

    OwnerDTO save(OwnerDTO d);

    void delete(Long id);
}