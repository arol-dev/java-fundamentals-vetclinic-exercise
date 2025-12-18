package com.example.vetclinic.servicies;

import java.util.List;


import org.springframework.stereotype.Service;

import com.example.vetclinic.dto.OwnerDTO;
import com.example.vetclinic.entities.Owner;
import com.example.vetclinic.repositories.OwnerRpository;
import com.example.vetclinic.exception.NotFoundException;

import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {

	 private final OwnerRpository OwnerRpository;

	  public OwnerServiceImpl(OwnerRpository OwnerRpository) {
	    this.OwnerRpository = OwnerRpository;
	  }

	  @Override
	  @Transactional(readOnly = true)
	  public List<OwnerDTO> getAll() {
	    return OwnerRpository.findAll()
	        .stream()
	        .map(this::toDto)
	        .toList();
	  }

	  @Override
	  public OwnerDTO create(OwnerDTO dto) {
	    validateOwner(dto);

	    Owner owner = new Owner();
	    owner.setName(dto.name());
	    owner.setPhone(dto.phone());
	    owner.setAddress(dto.address());

	    Owner saved = OwnerRpository.save(owner);
	    return toDto(saved);
	  }

	  @Override
	  public void delete(Long id) {
	    if (id == null) throw new IllegalArgumentException("Owner id requerido");

	    if (!OwnerRpository.existsById(id)) {
	      throw new NotFoundException("Owner no encontrado");
	    }
	    OwnerRpository.deleteById(id);
	  }

	  private void validateOwner(OwnerDTO dto) {
	    if (dto == null) throw new IllegalArgumentException("Owner requerido");
	    if (dto.name() == null || dto.name().isBlank()) {
	      throw new IllegalArgumentException("Nombre del Owner required");
	    }
	  }

	  private OwnerDTO toDto(Owner owner) {
	    return new OwnerDTO(
	        owner.getId(),
	        owner.getName(),
	        owner.getPhone(),
	        owner.getAddress()
	    );
	  }
		
	}

