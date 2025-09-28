package java.fundamentals.vetclinic.visit.DTO;


import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class VisitDTO {

    private long id;
    private String reason;
    private long petId;
}
