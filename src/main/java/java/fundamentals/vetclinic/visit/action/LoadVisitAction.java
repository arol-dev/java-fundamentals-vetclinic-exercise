package java.fundamentals.vetclinic.visit.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.pet.model.PetModel;
import java.fundamentals.vetclinic.pet.repository.PetRepository;
import java.fundamentals.vetclinic.visit.DTO.VisitWithPetDTO;
import java.fundamentals.vetclinic.visit.mapper.VisitWithPetMapper;
import java.fundamentals.vetclinic.visit.model.VisitModel;
import java.fundamentals.vetclinic.visit.repository.VisitRepository;


@Service
public class LoadVisitAction {

    @Autowired
    private VisitRepository visitRepository;

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private VisitWithPetMapper visitWithPetMapper;

    public VisitWithPetDTO getVisitById(long id){

        VisitModel visitModel = visitRepository.findById(id);
        PetModel petModel = petRepository.findById(visitModel.getPetId());


        return visitWithPetMapper.toTO(petModel, visitModel);
    }
}
