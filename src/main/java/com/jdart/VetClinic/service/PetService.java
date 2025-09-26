package com.jdart.VetClinic.service;

import com.jdart.VetClinic.dto.PetDTO;
import com.jdart.VetClinic.model.Pet;
import com.jdart.VetClinic.model.Owner;
import com.jdart.VetClinic.repository.PetRepository;
import com.jdart.VetClinic.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PetService {
    private static PetRepository petRepository = null;
    private static OwnerRepository ownerRepository = null;
    private static ModelMapper modelMapper = null;

    public PetService(PetRepository petRepository, OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.petRepository = petRepository;
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    public List<PetDTO> getAllPets() {
        return (List<PetDTO>) petRepository.findAll().stream()
                .map(pet -> modelMapper.map(pet, PetDTO.class))
                .collect(Collectors.toList());
    }

    public static PetDTO savePet(Pet petDTO) {
        Pet pet = modelMapper.map(petDTO, Pet.class);
        Owner owner = ownerRepository.findById(petDTO.getOwnerId())
                .orElseThrow(() -> new RuntimeException("Owner not found"));
        pet.setOwner(owner);
        Pet saved = (Pet) petRepository.save(pet);
        return modelMapper.map(saved, PetDTO.class);
    }
}
