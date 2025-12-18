package com.example.vetclinic.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

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
public class Pet {

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(nullable = false)
	  private String name;

	  @Column(nullable = false)
	  private String type; 

	  private LocalDate birthDate;

	  @ManyToOne(optional = false, fetch = FetchType.LAZY)
	  @JoinColumn(name = "owner_id", nullable = false)
	  private Owner owner;

	  @OneToMany(mappedBy = "pet", cascade = CascadeType.ALL, orphanRemoval = true)
	  private List<Visit> visits = new ArrayList<>();

	  public Long getId() {
		  return id;
	  }

	  public void setId(Long id) {
		  this.id = id;
	  }

	  public String getName() {
		  return name;
	  }

	  public void setName(String name) {
		  this.name = name;
	  }

	  public String getType() {
		  return type;
	  }

	  public void setType(String type) {
		  this.type = type;
	  }

	  public LocalDate getBirthDate() {
		  return birthDate;
	  }

	  public void setBirthDate(LocalDate birthDate) {
		  this.birthDate = birthDate;
	  }

	  public Owner getOwner() {
		  return owner;
	  }

	  public void setOwner(Owner owner) {
		  this.owner = owner;
	  }

	  public List<Visit> getVisits() {
		  return visits;
	  }

	  public void setVisits(List<Visit> visits) {
		  this.visits = visits;
	  }
	  
	  
	  
	  
}
