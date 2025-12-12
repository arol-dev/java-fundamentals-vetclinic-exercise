package com.acuadrado.vetclinic.mapper;

import com.acuadrado.vetclinic.dto.PetDto;
import com.acuadrado.vetclinic.entity.Owner;
import com.acuadrado.vetclinic.entity.Pet;
import com.acuadrado.vetclinic.repository.OwnerRepository;
import org.springframework.stereotype.Component;

@Component
public class PetMapper {

    private final OwnerRepository ownerRepository;

    public PetMapper(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public PetDto toDto(Pet pet) {
        PetDto dto = new PetDto();
        dto.setId(pet.getId());
        dto.setName(pet.getName());
        dto.setType(pet.getType());
        dto.setBirthDate(pet.getBirthDate());
        dto.setOwnerId(pet.getOwner().getId());
        return dto;
    }

    public Pet toEntity(PetDto dto) {
        Pet pet = new Pet();
        pet.setId(dto.getId());
        pet.setName(dto.getName());
        pet.setType(dto.getType());
        pet.setBirthDate(dto.getBirthDate());

        Owner owner = ownerRepository.findById(dto.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));

        pet.setOwner(owner);

        return pet;
    }
}
