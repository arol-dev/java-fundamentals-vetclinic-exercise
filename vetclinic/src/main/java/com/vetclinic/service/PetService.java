package com.vetclinic.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import com.vetclinic.dto.PetDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.model.Pet;
import com.vetclinic.repository.PetRepository;

@Service
public class PetService {

    private final ModelMapper modelMapper;
    private final PetRepository petRepository;

    public PetService (PetRepository petRepository, ModelMapper modelMapper) {
        this.petRepository= petRepository;
        this.modelMapper = modelMapper;
    }

    // Verificación de guardado de mascota
    public PetDTO save(PetDTO petDTO) {
        Pet pet = modelMapper.map(petDTO, Pet.class);

        if (pet.getBirthDate().isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("La fecha de nacimiento no puede ser del futuro");
        }

        if (petDTO.getOwnerId() == null) {
            throw new IllegalArgumentException("La mascota debe tener un dueño con id informado");
        }
        Owner owner = new Owner();
        owner.setId(petDTO.getOwnerId());
        pet.setOwner(owner);

        Pet savedPet = petRepository.save(pet);
        return modelMapper.map(savedPet, PetDTO.class);
    }

    // Verificación de borrado de mascota
    public void deleteById(Long id) {
        if (!petRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe una mascota con id " + id);
        }
        petRepository.deleteById(id);
    }

    // Métodos para el controlador
    public List<PetDTO> findAll() {
        return petRepository.findAll()
        .stream()
        .map(pet -> modelMapper.map(pet, PetDTO.class))
        .toList();
    }

    public Optional<PetDTO> findById(Long id) {
        return petRepository.findById(id)
        .map(pet -> modelMapper.map(pet, PetDTO.class));
    }
}
