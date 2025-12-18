package com.example.vetclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vetclinic.entities.Pet;

public interface PetRepository  extends JpaRepository<Pet, Long> {

}
