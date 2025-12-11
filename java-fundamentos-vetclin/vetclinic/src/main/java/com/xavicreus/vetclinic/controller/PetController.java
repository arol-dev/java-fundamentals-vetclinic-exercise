package com.xavicreus.vetclinic.controller;

import com.xavicreus.vetclinic.entity.Pet;
import com.xavicreus.vetclinic.service.PetService;
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
    public List<Pet> getAll() {
        return petService.findAll();
    }

    @PostMapping
    public Pet create(@RequestBody Pet pet) {
        return petService.save(pet);
    }
}