package com.xavicreus.vetclinic.service;

import com.xavicreus.vetclinic.entity.Visit;
import com.xavicreus.vetclinic.repository.VisitRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitService {

    private final VisitRepository visitRepository;

    public VisitService(VisitRepository visitRepository) {
        this.visitRepository = visitRepository;
    }

    public List<Visit> findAll() {
        return visitRepository.findAll();
    }

    @SuppressWarnings("null")
    public Visit save(Visit visit) {
        return visitRepository.save(visit);
    }
}
