package com.vetclinic.controller;

import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.dto.PetDTO;
import com.vetclinic.model.Pet;
import com.vetclinic.service.PetService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    private final PetService petService;
    private final ModelMapper modelMapper;

    public PetController(PetService petService) {
        this.petService = petService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    public List<PetDTO> getAllPets() {
        return petService.findAll()
        .stream()
        .map(pet -> modelMapper.map(pet, PetDTO.class))
        .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<PetDTO> getPetById(@PathVariable Long id) {
        return petService.findById(id)
                .map(pet -> ResponseEntity.ok(modelMapper.map(pet, PetDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<PetDTO> createPet(@RequestBody PetDTO pet) {
        PetDTO savedPet = petService.save(pet);
        return ResponseEntity.ok(savedPet);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePet(@PathVariable Long id) {
        petService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}