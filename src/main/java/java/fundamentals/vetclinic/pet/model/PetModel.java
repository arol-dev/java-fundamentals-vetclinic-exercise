package java.fundamentals.vetclinic.pet.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "pets")
@Getter
@Setter
@NoArgsConstructor
public class PetModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "pet_name", nullable = false, length = 100)
    private String petName;

    @Column(name = "type", nullable = false, length = 100)
    private String type;

    @Column(name = "birthdate")
    private LocalDate birthdate;

    @Column(name = "owner_id", length = 225)
    private long ownerId;
}
