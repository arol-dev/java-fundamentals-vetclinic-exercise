package com.vetclinic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vetclinic.dto.VisitDTO;
import com.vetclinic.model.Visit;
import com.vetclinic.repository.PetRepository;
import com.vetclinic.repository.VisitRepository;

@Service
public class VisitService {
    private final VisitRepository visitRepository;
    private final PetRepository petRepository;
    private final ModelMapper modelMapper;

    public VisitService (VisitRepository visitRepository, PetRepository petRepository) {
        this.visitRepository = visitRepository;
        this.petRepository = petRepository;
        this.modelMapper = new ModelMapper();
    }

    // Verificación de guardado de visita
    public VisitDTO save(VisitDTO visitDTO) {
        Visit visit = modelMapper.map(visitDTO, Visit.class);
        if (visit.getDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de la visita no puede ser futura");
        }

        Long petId = visit.getPet().getId();
        if (!petRepository.existsById(petId)) {
            throw new IllegalArgumentException("No existe la mascota con id " + petId);
        }

        Visit savedVisit = visitRepository.save(visit);

        return modelMapper.map(savedVisit, VisitDTO.class);
    }

    // Verificación de borrado de visita
    public void deleteById(Long id) {
        if (!visitRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una visita con id " + id);
        }
        visitRepository.deleteById(id);
    }

    // Métodos para el controlador
    public List<VisitDTO> findAll() {
        return visitRepository.findAll()
        .stream()
        .map(visit -> modelMapper.map(visit, VisitDTO.class))
        .toList();
    }

    public Optional<VisitDTO> findById(Long id) {
        return visitRepository.findById(id)
        .map (visit -> modelMapper.map(visit, VisitDTO.class));
    }
}