package com.example.vetclinic.controller;

import com.example.vetclinic.dto.PetDTO;
import com.example.vetclinic.servicies.PetService;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/pets")
public class PetController {

  private final PetService petService;

  public PetController(PetService petService) {
    this.petService = petService;
  }

  @GetMapping
  public List<PetDTO> getAll() {
    return petService.getAll();
  }

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PetDTO create(@RequestBody PetCreateBody body) {
    if (body == null) throw new IllegalArgumentException("Mascota requerida");
    if (body.owner() == null || body.owner().id() == null) {
      throw new IllegalArgumentException("owner.id requerido");
    }

    Long ownerId = body.owner().id();

    PetDTO petDTO = new PetDTO(
        null,
        body.name(),
        body.type(),
        body.birthDate()
    );

    return petService.create(ownerId, petDTO);
  }

  public record PetCreateBody(String name, String type, LocalDate birthDate, OwnerRef owner) {}
  public record OwnerRef(Long id) {}
}
