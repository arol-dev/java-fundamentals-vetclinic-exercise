package com.vetclinic.dto;

import java.time.LocalDate;

public class VisitDTO {
    private Long id;
    private LocalDate date;
    private String reason;
    private Long petId;

    public VisitDTO() {}

    public VisitDTO(Long id, LocalDate date, String reason, Long petId) {
        this.id = id;
        this.date = date;
        this.reason = reason;
        this.petId = petId;
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
    public Long getPetId() {
        return petId;
    }
    public void setPetId(Long petId) {
        this.petId = petId;
    }
}