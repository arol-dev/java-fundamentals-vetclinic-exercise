package java.fundamentals.vetclinic.pet.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.fundamentals.vetclinic.owner.mapper.OwnerMapper;
import java.fundamentals.vetclinic.owner.model.OwnerModel;
import java.fundamentals.vetclinic.pet.DTO.PetwithOwnerDTO;
import java.fundamentals.vetclinic.pet.model.PetModel;

@Component
public class PetWithOwnerMapper {

    @Autowired
    OwnerMapper ownerMapper;

    @Autowired
    PetMapper petMapper;

    public PetwithOwnerDTO petWithOwnerDTO(PetModel petModel, OwnerModel ownerModel) {

        PetwithOwnerDTO petwithOwnerDTO = new PetwithOwnerDTO();
        petwithOwnerDTO.setPetDTO(petMapper.toDTO(petModel));
        petwithOwnerDTO.setOwnerDTO(ownerMapper.toDTO(ownerModel));
        return petwithOwnerDTO;

    }
}
