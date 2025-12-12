package com.vetclinic.service;

import java.util.*;

import com.vetclinic.dto.*;

public interface VisitService {
    List<VisitDTO> findAll();

    VisitDTO findById(Long id);

    VisitDTO save(VisitDTO d);

    void delete(Long id);
}