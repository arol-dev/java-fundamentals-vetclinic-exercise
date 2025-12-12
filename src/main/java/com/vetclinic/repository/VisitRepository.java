package com.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vetclinic.entity.Visit;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}