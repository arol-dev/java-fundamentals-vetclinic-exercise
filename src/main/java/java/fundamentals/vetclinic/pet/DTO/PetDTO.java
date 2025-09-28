package java.fundamentals.vetclinic.pet.DTO;


import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PetDTO {

    private long id;
    private String name;
    private String type;
    private LocalDate birthDate;
    private long ownerId;
}
