package com.jdart.VetClinic.controller;

import com.jdart.VetClinic.dto.OwnerDTO;
import com.jdart.VetClinic.model.Owner;
import com.jdart.VetClinic.service.OwnerService;
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
    public List<OwnerDTO> getOwners() {
        return ownerService.getAllOwners();
    }

    @PostMapping
    public OwnerDTO createOwner(@RequestBody Owner owner) {
        return ownerService.saveOwner(owner);
    }
}
