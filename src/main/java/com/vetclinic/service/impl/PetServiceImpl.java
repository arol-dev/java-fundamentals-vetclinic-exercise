package com.vetclinic.service.impl;

import com.vetclinic.dto.PetDTO;
import com.vetclinic.mapper.PetMapper;
import com.vetclinic.entity.Owner;
import com.vetclinic.entity.Pet;
import com.vetclinic.repository.OwnerRepository;
import com.vetclinic.repository.PetRepository;
import com.vetclinic.service.PetService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PetServiceImpl implements PetService {
    private final PetRepository repository;
    private final OwnerRepository ownerRepository;
    private final PetMapper mapper;

    public PetServiceImpl(PetRepository repository, OwnerRepository ownerRepository, PetMapper mapper) {
        this.repository = repository;
        this.ownerRepository = ownerRepository;
        this.mapper = mapper;
    }

    @Override public List<PetDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
    @Override public PetDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Pet not found"));
    }
    @Override public PetDTO save(PetDTO dto) {
        Pet entity = mapper.toEntity(dto);
        if (dto.getOwner().getId() != null) {
            Owner owner = ownerRepository.findById(dto.getOwner().getId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
            entity.setOwner(owner);
        }
        return mapper.toDTO(repository.save(entity));
    }
    @Override public void delete(Long id) { repository.deleteById(id); }
}
