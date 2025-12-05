package java.fundamentals.vetclinic.visit.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import java.fundamentals.vetclinic.pet.mapper.PetMapper;
import java.fundamentals.vetclinic.pet.model.PetModel;
import java.fundamentals.vetclinic.visit.DTO.VisitWithPetDTO;
import java.fundamentals.vetclinic.visit.model.VisitModel;

@Component
public class VisitWithPetMapper {

    @Autowired
    VisitMapper visitMapper;

    @Autowired
    PetMapper petMapper;

    public VisitWithPetDTO toTO(PetModel petModel, VisitModel visitModel) {

        VisitWithPetDTO visitWithPetDTO = new VisitWithPetDTO();
        visitWithPetDTO.setPet(petMapper.toDTO(petModel));
        visitWithPetDTO.setVisit(visitMapper.toDTO(visitModel));
        return visitWithPetDTO;

    }
}
