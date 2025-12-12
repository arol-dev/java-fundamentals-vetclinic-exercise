package com.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vetclinic.entity.Pet;

public interface PetRepository extends JpaRepository<Pet, Long> {
}