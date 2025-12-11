package com.xavicreus.vetclinic.service;

import com.xavicreus.vetclinic.entity.Pet;
import com.xavicreus.vetclinic.repository.PetRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    private final PetRepository petRepository;

    public PetService(PetRepository petRepository) {
        this.petRepository = petRepository;
    }

    public List<Pet> findAll() {
        return petRepository.findAll();
    }

    @SuppressWarnings("null")
    public Pet save(Pet pet) {
        return petRepository.save(pet);
    }

    @SuppressWarnings("null")
    public Optional<Pet> findById(Long id) {
        return petRepository.findById(id);
    }
}
