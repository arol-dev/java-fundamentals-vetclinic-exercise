package java.fundamentals.vetclinic.pet.DTO;

import lombok.*;

import java.fundamentals.vetclinic.owner.DTO.OwnerDTO;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PetwithOwnerDTO {

    private PetDTO petDTO;
    private OwnerDTO ownerDTO;
}
