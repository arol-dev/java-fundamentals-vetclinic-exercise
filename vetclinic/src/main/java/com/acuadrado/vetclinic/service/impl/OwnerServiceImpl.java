package com.acuadrado.vetclinic.service.impl;

import com.acuadrado.vetclinic.dto.OwnerDto;
import com.acuadrado.vetclinic.entity.Owner;
import com.acuadrado.vetclinic.mapper.OwnerMapper;
import com.acuadrado.vetclinic.repository.OwnerRepository;
import com.acuadrado.vetclinic.service.OwnerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {

    private final OwnerRepository ownerRepository;
    private final OwnerMapper ownerMapper;

    public OwnerServiceImpl(OwnerRepository ownerRepository, OwnerMapper ownerMapper) {
        this.ownerRepository = ownerRepository;
        this.ownerMapper = ownerMapper;
    }

    @Override
    public List<OwnerDto> findAll() {
        return ownerRepository.findAll()
                .stream()
                .map(ownerMapper::toDto)
                .toList();
    }

    @Override
    public OwnerDto create(OwnerDto ownerDto) {
        Owner owner = ownerMapper.toEntity(ownerDto);
        Owner saved = ownerRepository.save(owner);
        return ownerMapper.toDto(saved);
    }
}
