package com.acuadrado.vetclinic.controller;

import com.acuadrado.vetclinic.dto.VisitDto;
import com.acuadrado.vetclinic.service.VisitService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/visits")
public class VisitController {

    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public ResponseEntity<List<VisitDto>> getAllVisits() {
        return ResponseEntity.ok(visitService.findAll());
    }

    @PostMapping
    public ResponseEntity<VisitDto> createVisit(@RequestBody VisitDto visitDto) {
        VisitDto created = visitService.create(visitDto);
        return new ResponseEntity<>(created, HttpStatus.CREATED);
    }
}
