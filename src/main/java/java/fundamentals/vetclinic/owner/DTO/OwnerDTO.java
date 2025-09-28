package java.fundamentals.vetclinic.owner.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class OwnerDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;
}
