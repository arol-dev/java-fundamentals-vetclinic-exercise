package com.jdart.VetClinic.dto;

import java.time.LocalDate;

public class PetDTO {
    private Long id;
    private String name;
    private String type;
    private LocalDate birthDate; // Puedes usar LocalDate si prefieres

    private Long ownerId;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public LocalDate getBirthDate() { return birthDate; }
    public void setBirthDate(String birthDate) { this.birthDate = LocalDate.parse(birthDate); }

    public Long getOwnerId() { return ownerId; }
    public void setOwnerId(Long ownerId) { this.ownerId = ownerId; }
}
