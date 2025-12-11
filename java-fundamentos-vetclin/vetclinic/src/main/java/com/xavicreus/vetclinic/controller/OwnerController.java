package com.xavicreus.vetclinic.controller;

import com.xavicreus.vetclinic.entity.Owner;
import com.xavicreus.vetclinic.service.OwnerService;
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
    public List<Owner> getAll() {
        return ownerService.findAll();
    }

    @PostMapping
    public Owner create(@RequestBody Owner owner) {
        return ownerService.save(owner);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        ownerService.deleteById(id);
    }
}