package com.vetclinic.controller;

import org.springframework.web.bind.annotation.*;

import java.util.*;

import com.vetclinic.service.*;
import com.vetclinic.dto.*;

@RestController
@RequestMapping("/visits")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<VisitDTO> all() {
        return visitService.findAll();
    }

    @PostMapping
    public VisitDTO save(@RequestBody VisitDTO d) {
        return visitService.save(d);
    }
}