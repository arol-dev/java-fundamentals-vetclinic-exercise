package com.example.vetclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vetclinic.entities.Owner;

public interface OwnerRpository  extends JpaRepository<Owner, Long> {

}
