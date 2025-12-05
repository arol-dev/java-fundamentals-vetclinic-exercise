package com.vetclinic.controller;

import com.vetclinic.dto.VisitDTO;
import com.vetclinic.model.Visit;
import com.vetclinic.service.VisitService;

import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;
    private final ModelMapper modelMapper;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
        this.modelMapper = new ModelMapper();
    }

    @GetMapping
    public List<VisitDTO> getAllVisits() {
        return visitService.findAll()
        .stream()
        .map(visit -> modelMapper.map(visit, VisitDTO.class))
        .toList();
    }

    @GetMapping("/{id}")
    public ResponseEntity<VisitDTO> getVisitById(@PathVariable Long id) {
        return visitService.findById(id)
                .map(visit -> ResponseEntity.ok(modelMapper.map(visit, VisitDTO.class)))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<VisitDTO> createVisit(@RequestBody VisitDTO visit) {
        VisitDTO savedVisit = visitService.save(visit);
        return ResponseEntity.ok(savedVisit);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteVisit(@PathVariable Long id) {
        visitService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}