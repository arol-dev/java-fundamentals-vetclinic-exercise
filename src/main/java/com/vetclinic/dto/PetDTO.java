package com.vetclinic.dto;

import java.time.LocalDate;

public class PetDTO {

    private Long id;
    private String name;
    private String type;
    private LocalDate birthDate;
    private OwnerDTO owner;

    public PetDTO() {
    }

    public PetDTO(Long id, String name, String type, LocalDate birthDate, OwnerDTO owner) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.birthDate = birthDate;
        this.owner = owner;
    }

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

    public OwnerDTO getOwner() {
        return owner;
    }

    public void setOwner(OwnerDTO owner) {
        this.owner = owner;
    }
}
