package com.example.vetclinic.servicies;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import com.example.vetclinic.dto.VisitDTO;

import com.example.vetclinic.entities.Pet;
import com.example.vetclinic.entities.Visit;

import com.example.vetclinic.repositories.PetRepository;
import com.example.vetclinic.repositories.VisitRpository;
import com.example.vetclinic.exception.NotFoundException;


@Service
@Transactional
public class VisitServiceImpl implements VisitService {

  private final VisitRpository visitRepository;
  private final PetRepository petRepository;

  public VisitServiceImpl(VisitRpository visitRepository, PetRepository petRepository) {
    this.visitRepository = visitRepository;
    this.petRepository = petRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<VisitDTO> getAll() {
    return visitRepository.findAll()
        .stream()
        .map(this::toDto)
        .toList();
  }

  @Override
  public VisitDTO create(VisitDTO dto) {
    validateVisit(dto);

    Pet pet = petRepository.findById(dto.petId())
        .orElseThrow(() -> new NotFoundException("Mascota no encontrado: " + dto.petId()));

    Visit visit = new Visit();
    visit.setDate(dto.date());
    visit.setReason(dto.reason());
    visit.setPet(pet);

    Visit saved = visitRepository.save(visit);
    return toDto(saved);
  }

  private void validateVisit(VisitDTO dto) {
    if (dto == null) throw new IllegalArgumentException("PROBAAAAAAAANDO");
    if (dto.date() == null) throw new IllegalArgumentException("fecha requerida");
    if (dto.reason() == null || dto.reason().isBlank()) {
      throw new IllegalArgumentException("Campo requerido");
    }
    if (dto.petId() == null) throw new IllegalArgumentException("petId obligatorio");
  }

  private VisitDTO toDto(Visit visit) {
    return new VisitDTO(
        visit.getId(),
        visit.getDate(),
        visit.getReason(),
        visit.getPet() != null ? visit.getPet().getId() : null
    );
  }

}
