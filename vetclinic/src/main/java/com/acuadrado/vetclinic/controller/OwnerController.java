package com.acuadrado.vetclinic.controller;

import com.acuadrado.vetclinic.dto.OwnerDto;
import com.acuadrado.vetclinic.service.OwnerService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public ResponseEntity<List<OwnerDto>> getAllOwners() {
        return ResponseEntity.ok(ownerService.findAll());
    }

    @PostMapping
    public ResponseEntity<OwnerDto> createOwner(@RequestBody OwnerDto ownerDto) {
        OwnerDto created = ownerService.create(ownerDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
