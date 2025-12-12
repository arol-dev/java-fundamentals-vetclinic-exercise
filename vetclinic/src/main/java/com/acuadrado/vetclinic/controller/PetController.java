package com.acuadrado.vetclinic.controller;

import com.acuadrado.vetclinic.dto.PetDto;
import com.acuadrado.vetclinic.service.PetService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<PetDto>> getAllPets() {
        return ResponseEntity.ok(petService.findAll());
    }

    @PostMapping
    public ResponseEntity<PetDto> createPet(@RequestBody PetDto petDto) {
        PetDto created = petService.create(petDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
