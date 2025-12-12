package com.acuadrado.vetclinic.service.impl;

import com.acuadrado.vetclinic.dto.PetDto;
import com.acuadrado.vetclinic.entity.Owner;
import com.acuadrado.vetclinic.entity.Pet;
import com.acuadrado.vetclinic.mapper.PetMapper;
import com.acuadrado.vetclinic.repository.OwnerRepository;
import com.acuadrado.vetclinic.repository.PetRepository;
import com.acuadrado.vetclinic.service.PetService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PetServiceImpl implements PetService {

    private final PetRepository petRepository;
    private final OwnerRepository ownerRepository;
    private final PetMapper petMapper;

    public PetServiceImpl(PetRepository petRepository, OwnerRepository ownerRepository, PetMapper petMapper) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.petMapper = petMapper;
    }

    @Override
    public List<PetDto> findAll() {
        return petRepository.findAll()
                .stream()
                .map(petMapper::toDto)
                .toList();
    }

    @Override
    public PetDto create(PetDto petDto) {
        // Convertir DTO → entidad
        Pet pet = petMapper.toEntity(petDto);

        // Validar owner
        Owner owner = ownerRepository.findById(petDto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        pet.setOwner(owner);

        Pet saved = petRepository.save(pet);
        return petMapper.toDto(saved);
    }
}
