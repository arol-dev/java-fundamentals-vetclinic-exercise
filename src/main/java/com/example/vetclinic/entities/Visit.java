package com.example.vetclinic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import java.time.LocalDate;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;

@Entity
public class Visit {

	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(nullable = false)
	  private LocalDate date;

	  @Column(nullable = false)
	  private String reason;

	  @ManyToOne(optional = false, fetch = FetchType.LAZY)
	  @JoinColumn(name = "pet_id", nullable = false)
	  private Pet pet;

	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
		  this.id = id;
	  }

	  public LocalDate getDate() {
		  return date;
	  }

	  public void setDate(LocalDate date) {
		  this.date = date;
	  }

	  public String getReason() {
		  return reason;
	  }

	  public void setReason(String reason) {
		  this.reason = reason;
	  }

	  public Pet getPet() {
		  return pet;
	  }

	  public void setPet(Pet pet) {
		  this.pet = pet;
	  }
	  
	  
	  
}
