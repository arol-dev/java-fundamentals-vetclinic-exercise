package com.example.vetclinic.entities;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Owner {

	 @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	  private Long id;

	  @Column(nullable = false)
	  private String name;

	  private String phone;
	  private String address;

	  @OneToMany(mappedBy = "owner", cascade = CascadeType.ALL, orphanRemoval = true)
	  private List<Pet> pets = new ArrayList<>();

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

	  public String getPhone() {
		  return phone;
	  }

	  public void setPhone(String phone) {
		  this.phone = phone;
	  }

	  public String getAddress() {
		  return address;
	  }

	  public void setAddress(String address) {
		  this.address = address;
	  }

	  public List<Pet> getPets() {
		  return pets;
	  }

	  public void setPets(List<Pet> pets) {
		  this.pets = pets;
	  }
	  
	  
}
