package com.jdart.VetClinic.dto;

public class VisitDTO {
    private Long id;
    private String date; // Puedes usar LocalDate si prefieres
    private String reason;

    private Long petId;

    // Getters y setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public String getReason() { return reason; }
    public void setReason(String reason) { this.reason = reason; }

    public Long getPetId() { return petId; }
    public void setPetId(Long petId) { this.petId = petId; }
}
