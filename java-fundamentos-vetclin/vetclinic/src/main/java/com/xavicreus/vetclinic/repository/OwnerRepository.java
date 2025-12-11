package com.xavicreus.vetclinic.repository;

import com.xavicreus.vetclinic.entity.Owner;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OwnerRepository extends JpaRepository<Owner, Long> {
}