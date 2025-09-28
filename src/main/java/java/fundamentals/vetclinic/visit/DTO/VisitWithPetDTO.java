package java.fundamentals.vetclinic.visit.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.fundamentals.vetclinic.pet.DTO.PetDTO;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class VisitWithPetDTO {

    private VisitDTO visit;
    private PetDTO pet;
}
