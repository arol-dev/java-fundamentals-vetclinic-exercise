package com.jdart.VetClinic.repository;

import com.jdart.VetClinic.model.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {}