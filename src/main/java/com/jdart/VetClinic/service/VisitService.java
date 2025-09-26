package com.jdart.VetClinic.service;

import com.jdart.VetClinic.dto.VisitDTO;
import com.jdart.VetClinic.model.*;
import com.jdart.VetClinic.model.Pet;
import com.jdart.VetClinic.repository.VisitRepository;
import com.jdart.VetClinic.repository.PetRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class VisitService {
    private static VisitRepository visitRepository = null;
    private static PetRepository petRepository = null;
    private static ModelMapper modelMapper = null;

    public VisitService(VisitRepository visitRepository, PetRepository petRepository, ModelMapper modelMapper) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.modelMapper = modelMapper;
    }

    public List<VisitDTO> getAllVisits() {
        return visitRepository.findAll().stream()
                .map(visit -> modelMapper.map(visit, VisitDTO.class))
                .collect(Collectors.toList());
    }

    public static VisitDTO saveVisit(Visit visitDTO) throws Throwable {
        Visit visit = modelMapper.map(visitDTO, Visit.class);
        Pet pet = (Pet) petRepository.findById(visitDTO.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));
        visit.setPet(pet);
        Visit saved = visitRepository.save(visit);
        return modelMapper.map(saved, VisitDTO.class);
    }
}
