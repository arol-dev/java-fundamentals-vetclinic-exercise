package com.jdart.VetClinic.service;

import com.jdart.VetClinic.dto.OwnerDTO;
import com.jdart.VetClinic.model.Owner;
import com.jdart.VetClinic.repository.OwnerRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public OwnerService(OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    public List<OwnerDTO> getAllOwners() {
        return ownerRepository.findAll().stream()
                .map(owner -> modelMapper.map(owner, OwnerDTO.class))
                .collect(Collectors.toList());
    }

    public OwnerDTO saveOwner(Owner ownerDTO) {
        Owner owner = modelMapper.map(ownerDTO, Owner.class);
        Owner saved = ownerRepository.save(owner);
        return modelMapper.map(saved, OwnerDTO.class);
    }
}
