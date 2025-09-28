package java.fundamentals.vetclinic.visit.model;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "visits")
@Getter
@Setter
@NoArgsConstructor
public class VisitModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "date", nullable = false, length = 100)
    private LocalDateTime dateTime;

    @Column(name = "reason", nullable = false, length = 100)
    private String reason;

    @Column(name = "pet_id")
    private long petId;
}
