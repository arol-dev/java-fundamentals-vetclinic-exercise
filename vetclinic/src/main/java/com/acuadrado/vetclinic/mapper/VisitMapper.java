package com.acuadrado.vetclinic.mapper;

import com.acuadrado.vetclinic.dto.VisitDto;
import com.acuadrado.vetclinic.entity.Pet;
import com.acuadrado.vetclinic.entity.Visit;
import com.acuadrado.vetclinic.repository.PetRepository;
import org.springframework.stereotype.Component;

@Component
public class VisitMapper {

    private final PetRepository petRepository;

    public VisitMapper(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public VisitDto toDto(Visit visit) {
        VisitDto dto = new VisitDto();
        dto.setId(visit.getId());
        dto.setDate(visit.getDate());
        dto.setReason(visit.getReason());
        dto.setPetId(visit.getPet().getId());
        return dto;
    }

    public Visit toEntity(VisitDto dto) {
        Visit visit = new Visit();
        visit.setId(dto.getId());
        visit.setDate(dto.getDate());
        visit.setReason(dto.getReason());

        Pet pet = petRepository.findById(dto.getPetId())
                .orElseThrow(() -> new RuntimeException("Pet not found"));

        visit.setPet(pet);

        return visit;
    }
}
