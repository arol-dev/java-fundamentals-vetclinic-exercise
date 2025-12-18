package com.example.vetclinic.controller;


import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import com.example.vetclinic.dto.OwnerDTO;
import com.example.vetclinic.servicies.OwnerService;

@RestController
@RequestMapping("/api/owners")
public class OwnerController {

	  private final OwnerService ownerService;

	  public OwnerController(OwnerService ownerService) {
	    this.ownerService = ownerService;
	  }

	  @GetMapping
	  public List<OwnerDTO> getAll() {
	    return ownerService.getAll();
	  }

	  @PostMapping
	  @ResponseStatus(HttpStatus.CREATED)
	  public OwnerDTO create(@RequestBody OwnerDTO ownerDTO) {
	    return ownerService.create(ownerDTO);
	  }

	  @DeleteMapping("/{id}")
	  @ResponseStatus(HttpStatus.NO_CONTENT)
	  public void delete(@PathVariable Long id) {
	    ownerService.delete(id);
	  }
}
