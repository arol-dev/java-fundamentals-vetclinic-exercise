package com.jdart.VetClinic.repository;

import com.jdart.VetClinic.model.Visit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitRepository extends JpaRepository<Visit, Long> {}