package com.acuadrado.vetclinic.service.impl;

import com.acuadrado.vetclinic.dto.VisitDto;
import com.acuadrado.vetclinic.entity.Pet;
import com.acuadrado.vetclinic.entity.Visit;
import com.acuadrado.vetclinic.mapper.VisitMapper;
import com.acuadrado.vetclinic.repository.PetRepository;
import com.acuadrado.vetclinic.repository.VisitRepository;
import com.acuadrado.vetclinic.service.VisitService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {

    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final VisitMapper visitMapper;

    public VisitServiceImpl(VisitRepository visitRepository, PetRepository petRepository, VisitMapper visitMapper) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.visitMapper = visitMapper;
    }

    @Override
    public List<VisitDto> findAll() {
        return visitRepository.findAll()
                .stream()
                .map(visitMapper::toDto)
                .toList();
    }

    @Override
    public VisitDto create(VisitDto visitDto) {

        Pet pet = petRepository.findById(visitDto.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        Visit visit = visitMapper.toEntity(visitDto);
        visit.setPet(pet);

        Visit saved = visitRepository.save(visit);
        return visitMapper.toDto(saved);
    }
}
