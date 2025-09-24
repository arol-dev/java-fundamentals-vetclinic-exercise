package com.vetclinic.controller;

import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.service.OwnerService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    private final OwnerService ownerService;
    private final ModelMapper modelMapper;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    public List<OwnerDTO> getAllOwners() {
        return ownerService.findAll()
        .stream()
        .map(owner -> modelMapper.map(owner, OwnerDTO.class)).toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OwnerDTO> getOwnerById(@PathVariable Long id) {
        return ownerService.findById(id)
                .map(owner -> ResponseEntity.ok(modelMapper.map(owner, OwnerDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<OwnerDTO> createOwner(@RequestBody OwnerDTO Owner) {
        OwnerDTO savedOwner = ownerService.save(Owner);
        return ResponseEntity.ok(savedOwner);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}