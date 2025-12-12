package com.vetclinic.service.impl;

import com.vetclinic.dto.VisitDTO;
import com.vetclinic.mapper.VisitMapper;
import com.vetclinic.entity.Pet;
import com.vetclinic.entity.Visit;
import com.vetclinic.repository.PetRepository;
import com.vetclinic.repository.VisitRepository;
import com.vetclinic.service.VisitService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class VisitServiceImpl implements VisitService {
    private final VisitRepository repository;
    private final PetRepository petRepository;
    private final VisitMapper mapper;

    public VisitServiceImpl(VisitRepository repository, PetRepository petRepository, VisitMapper mapper) {
        this.repository = repository;
        this.petRepository = petRepository;
        this.mapper = mapper;
    }

    @Override public List<VisitDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
    @Override public VisitDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Visit not found"));
    }
    @Override public VisitDTO save(VisitDTO dto) {
        Visit entity = mapper.toEntity(dto);
        Pet pet = petRepository.findById(dto.getPet().getId())
            .orElseThrow(() -> new RuntimeException("Pet not found"));
        entity.setPet(pet);
        return mapper.toDTO(repository.save(entity));
    }
    @Override public void delete(Long id) { repository.deleteById(id); }
}
