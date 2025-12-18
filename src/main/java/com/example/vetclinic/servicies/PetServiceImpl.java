package com.example.vetclinic.servicies;


import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.vetclinic.dto.PetDTO;
import com.example.vetclinic.entities.Owner;
import com.example.vetclinic.entities.Pet;
import com.example.vetclinic.exception.NotFoundException;

import java.util.List;
import com.example.vetclinic.repositories.OwnerRpository;
import com.example.vetclinic.repositories.PetRepository;

@Service
@Transactional
public class PetServiceImpl implements PetService {

  private final PetRepository petRepository;
  private final OwnerRpository ownerRepository;

  public PetServiceImpl(PetRepository petRepository, OwnerRpository ownerRepository) {
    this.petRepository = petRepository;
    this.ownerRepository = ownerRepository;
  }

  @Override
  @Transactional(readOnly = true)
  public List<PetDTO> getAll() {
    return petRepository.findAll()
        .stream()
        .map(this::toDto)
        .toList();
  }

  @Override
  public PetDTO create(Long ownerId, PetDTO dto) {
    validatePet(dto);
    if (ownerId == null) throw new IllegalArgumentException("ownerId rquerido");

    Owner owner = ownerRepository.findById(ownerId)
        .orElseThrow(() -> new NotFoundException("Owner no encontrado: " + ownerId));

    Pet pet = new Pet();
    pet.setName(dto.name());
    pet.setType(dto.type());
    pet.setBirthDate(dto.birthDate());
    pet.setOwner(owner);

    Pet saved = petRepository.save(pet);
    return toDto(saved);
  }

  private void validatePet(PetDTO dto) {
    if (dto == null) throw new IllegalArgumentException("Petrequerido");
    if (dto.name() == null || dto.name().isBlank()) {
      throw new IllegalArgumentException("Nombre del la mascota requerido");
    }
    if (dto.type() == null || dto.type().isBlank()) {
      throw new IllegalArgumentException("Tipo de mascota requerido");
    }
  }

  private PetDTO toDto(Pet pet) {
    return new PetDTO(
        pet.getId(),
        pet.getName(),
        pet.getType(),
        pet.getBirthDate()
    );
  }
}

