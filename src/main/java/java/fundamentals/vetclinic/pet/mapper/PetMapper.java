package java.fundamentals.vetclinic.pet.mapper;

import org.springframework.stereotype.Component;

import java.fundamentals.vetclinic.pet.DTO.PetDTO;
import java.fundamentals.vetclinic.pet.model.PetModel;


@Component
public class PetMapper {

    public PetDTO toDTO(PetModel petModel){
        if(petModel == null) return null;
        return new PetDTO(
                petModel.getId(),
                petModel.getPetName(),
                petModel.getType(),
                petModel.getBirthdate(),
                petModel.getOwnerId()
        );


    }

    public PetModel toModel(PetDTO petDTO){
        if(petDTO == null) return null;
        PetModel petModel = new PetModel();
        petModel.setId(petDTO.getId());
        petModel.setPetName(petDTO.getName());
        petModel.setType(petDTO.getType());
        petModel.setBirthdate(petDTO.getBirthDate());
        petModel.setOwnerId(petDTO.getOwnerId());

        return petModel;

    }
}
