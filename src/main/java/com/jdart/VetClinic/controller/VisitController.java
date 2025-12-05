package com.jdart.VetClinic.controller;

import com.jdart.VetClinic.dto.VisitDTO;
import com.jdart.VetClinic.model.Visit;
import com.jdart.VetClinic.service.VisitService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Visit")
public class VisitController {
    private final VisitService visitService;

    public VisitController(VisitService visitService) {
        this.visitService = visitService;
    }

    @GetMapping
    public List<VisitDTO> getVisits() {
        return visitService.getAllVisits();
    }

    @PostMapping
    public VisitDTO createVisit(@RequestBody Visit visit) throws Throwable {
        return VisitService.saveVisit(visit);
    }
}
