package com.jdart.VetClinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PetRepository<Pet> extends JpaRepository<Pet, Long> {}