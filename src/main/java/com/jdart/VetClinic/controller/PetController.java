package com.jdart.VetClinic.controller;

import com.jdart.VetClinic.dto.PetDTO;
import com.jdart.VetClinic.model.Pet;
import com.jdart.VetClinic.service.PetService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDTO> getPets() {
        return petService.getAllPets();
    }

    @PostMapping
    public PetDTO createPet(@RequestBody Pet pet) {
        return PetService.savePet(pet);
    }
}
