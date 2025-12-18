package com.example.vetclinic.servicies;

import java.util.List;

import com.example.vetclinic.dto.OwnerDTO;

public interface OwnerService {
	 List<OwnerDTO> getAll();
	 OwnerDTO create(OwnerDTO req);
	  void delete(Long id);
}
