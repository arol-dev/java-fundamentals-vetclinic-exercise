package com.vetclinic.service.impl;

import com.vetclinic.dto.OwnerDTO;
import com.vetclinic.mapper.OwnerMapper;
import com.vetclinic.entity.Owner;
import com.vetclinic.repository.OwnerRepository;
import com.vetclinic.service.OwnerService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class OwnerServiceImpl implements OwnerService {
    private final OwnerRepository repository;
    private final OwnerMapper mapper;

    public OwnerServiceImpl(OwnerRepository repository, OwnerMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override public List<OwnerDTO> findAll() {
        return repository.findAll().stream().map(mapper::toDTO).toList();
    }
    @Override public OwnerDTO findById(Long id) {
        return repository.findById(id).map(mapper::toDTO)
            .orElseThrow(() -> new RuntimeException("Owner not found"));
    }
    @Override public OwnerDTO save(OwnerDTO dto) {
        Owner saved = repository.save(mapper.toEntity(dto));
        return mapper.toDTO(saved);
    }
    @Override public void delete(Long id) { repository.deleteById(id); }
}
