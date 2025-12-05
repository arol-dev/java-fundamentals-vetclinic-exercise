package java.fundamentals.vetclinic.owner.mapper;


import org.springframework.stereotype.Component;

import java.fundamentals.vetclinic.owner.DTO.OwnerDTO;
import java.fundamentals.vetclinic.owner.model.OwnerModel;

@Component
public class OwnerMapper {

    public OwnerDTO toDTO(OwnerModel ownerModel){
        if(ownerModel == null) return null;
        return new OwnerDTO(
                ownerModel.getId(),
                ownerModel.getFirstName(),
                ownerModel.getLastName(),
                ownerModel.getPhone(),
                ownerModel.getAddress()
        );


    }

    public OwnerModel toModel(OwnerDTO ownerDTO){
        if(ownerDTO == null) return null;
        OwnerModel ownerModel = new OwnerModel();
        ownerModel.setFirstName(ownerDTO.getFirstName());
        ownerModel.setLastName(ownerDTO.getLastName());
        ownerModel.setPhone(ownerDTO.getPhone());
        ownerModel.setAddress(ownerDTO.getAddress());
        return ownerModel;

    }
}
