package com.vetclinic.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.vetclinic.entity.Owner;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}