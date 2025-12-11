package com.xavicreus.vetclinic.service;

import com.xavicreus.vetclinic.entity.Owner;
import com.xavicreus.vetclinic.repository.OwnerRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OwnerService {

    private final OwnerRepository ownerRepository;

    public OwnerService(OwnerRepository ownerRepository) {
        this.ownerRepository = ownerRepository;
    }

    public List<Owner> findAll() {
        return ownerRepository.findAll();
    }

    @SuppressWarnings("null")
    public Owner save(Owner owner) {
        return ownerRepository.save(owner);
    }

    @SuppressWarnings("null")
    public void deleteById(Long id) {
        ownerRepository.deleteById(id);
    }

    @SuppressWarnings("null")
    public Optional<Owner> findById(Long id) {
        return ownerRepository.findById(id);
    }
}
