package com.vetclinic.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.vetclinic.service.*;
import com.vetclinic.dto.*;

@RestController
@RequestMapping("/owners")
public class OwnerController {
    private final OwnerService ownerService;

    public OwnerController(OwnerService ownerService) {
        this.ownerService = ownerService;
    }

    @GetMapping
    public List<OwnerDTO> all() {
        return ownerService.findAll();
    }

    @PostMapping
    public OwnerDTO save(@RequestBody OwnerDTO d) {
        return ownerService.save(d);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOwner(@PathVariable Long id) {
        ownerService.delete(id);
        return ResponseEntity.noContent().build(); // 204 No Content
    }
}