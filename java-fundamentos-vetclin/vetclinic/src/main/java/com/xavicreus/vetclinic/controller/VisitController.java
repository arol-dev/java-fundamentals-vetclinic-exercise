package com.xavicreus.vetclinic.controller;

import com.xavicreus.vetclinic.entity.Visit;
import com.xavicreus.vetclinic.service.VisitService;
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
    public List<Visit> getAll() {
        return visitService.findAll();
    }

    @PostMapping
    public Visit create(@RequestBody Visit visit) {
        return visitService.save(visit);
    }
}