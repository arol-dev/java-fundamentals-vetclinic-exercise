package com.example.vetclinic.controller;

import com.example.vetclinic.dto.VisitDTO;
import com.example.vetclinic.servicies.VisitService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/visits")
public class VisitController {

  private final VisitService visitService;

  public VisitController(VisitService visitService) {
    this.visitService = visitService;
  }

  @GetMapping
  public List<VisitDTO> getAll() {
    return visitService.getAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public VisitDTO create(@RequestBody VisitCreateBody body) {
    if (body == null) throw new IllegalArgumentException("Visita requerida");
    if (body.pet() == null || body.pet().id() == null) {
      throw new IllegalArgumentException("pet.id requerida");
    }

    VisitDTO dto = new VisitDTO(
        null,
        body.date(),
        body.reason(),
        body.pet().id()
    );

    return visitService.create(dto);
  }

  public record VisitCreateBody(LocalDate date, String reason, PetRef pet) {}
  public record PetRef(Long id) {}
}