package com.xavicreus.vetclinic.repository;

import com.xavicreus.vetclinic.entity.Pet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository extends JpaRepository<Pet, Long> {
}
