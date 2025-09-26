package com.jdart.VetClinic.model;

import com.jdart.VetClinic.model.Pet;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.ManyToOne;
import org.springframework.data.annotation.Id;

import java.time.LocalDate;

@Entity
public class Visit{
    @Id
    @GeneratedValue
    private Long id;
    private LocalDate date;
    private String reason;

    @ManyToOne
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

    public Object getPetId() { return pet;
    }
}
