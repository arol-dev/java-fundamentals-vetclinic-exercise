package com.xavicreus.vetclinic.repository;

import com.xavicreus.vetclinic.entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {
}
