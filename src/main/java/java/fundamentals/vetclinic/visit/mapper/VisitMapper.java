package java.fundamentals.vetclinic.visit.mapper;


import org.springframework.stereotype.Component;

import java.fundamentals.vetclinic.pet.model.PetModel;
import java.fundamentals.vetclinic.visit.DTO.VisitDTO;
import java.fundamentals.vetclinic.visit.model.VisitModel;

@Component
public class VisitMapper {

    public VisitDTO toDTO(VisitModel visitModel){
        if(visitModel == null) return null;
        return new VisitDTO(
                visitModel.getId(),
                visitModel.getReason(),
                visitModel.getPetId()
        );


    }

    public VisitModel toModel(VisitDTO visitDTO){
        if(visitDTO == null) return null;
        VisitModel visitModel = new VisitModel();
        visitModel.setId(visitDTO.getId());
        visitModel.setReason(visitDTO.getReason());
        visitModel.setPetId(visitDTO.getPetId());
        return visitModel;
    }
}
