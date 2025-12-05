package com.vetclinic.service;

import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.model.Owner;
import com.vetclinic.repository.OwnerRepository;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class OwnerService {
    private final OwnerRepository ownerRepository;
    private final ModelMapper modelMapper;

    public OwnerService (OwnerRepository ownerRepository, ModelMapper modelMapper) {
        this.ownerRepository = ownerRepository;
        this.modelMapper = modelMapper;
    }

    public OwnerDTO save(OwnerDTO ownerDTO) {
        Owner owner = modelMapper.map(ownerDTO, Owner.class);
        Owner savedOwner = ownerRepository.save(owner);
        return modelMapper.map(savedOwner, OwnerDTO.class);
    }

    public void deleteById(Long id) {
        if (!ownerRepository.existsById(id)) {
            throw new IllegalArgumentException("No existe un dueño con el id " + id);
        }
        ownerRepository.deleteById(id);
    }

    // Métodos para el controlador
    public List<OwnerDTO> findAll() {
        return ownerRepository.findAll()
        .stream()
        .map(owner -> modelMapper.map(owner, OwnerDTO.class))
        .toList();
    }

    public Optional<OwnerDTO> findById(Long id) {
        return ownerRepository.findById(id)
        .map(owner -> modelMapper.map(owner, OwnerDTO.class));
    }

}
