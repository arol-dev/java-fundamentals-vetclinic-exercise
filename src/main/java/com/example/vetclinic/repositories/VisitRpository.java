package com.example.vetclinic.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.vetclinic.entities.Visit;

public interface VisitRpository  extends JpaRepository<Visit, Long> {

}
