package com.vetclinic.dto;

import java.time.LocalDate;

public class VisitDTO {

    private Long id;
    private LocalDate date;
    private String reason;
    private PetDTO pet;

    public VisitDTO() {
    }

    public VisitDTO(Long id, LocalDate date, String reason, PetDTO pet) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.pet = pet;
    }

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

    public PetDTO getPet() {
        return pet;
    }

    public void setPet(PetDTO pet) {
        this.pet = pet;
    }
}
