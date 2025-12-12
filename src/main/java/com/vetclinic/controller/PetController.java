package com.vetclinic.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.vetclinic.service.*;
import com.vetclinic.dto.*;

@RestController
@RequestMapping("/pets")
public class PetController {
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<PetDTO> all() {
        return petService.findAll();
    }

    @PostMapping
    public PetDTO save(@RequestBody PetDTO d) {
        return petService.save(d);
    }
}