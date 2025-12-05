package java.fundamentals.vetclinic.pet.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.pet.DTO.PetDTO;
import java.fundamentals.vetclinic.pet.mapper.PetMapper;
import java.fundamentals.vetclinic.pet.model.PetModel;
import java.fundamentals.vetclinic.pet.repository.PetRepository;

@Service
public class CrudPetAction {

    @Autowired
    PetRepository petRepository;

    @Autowired
    PetMapper petMapper;

    public PetDTO createPet(PetDTO petDTO){
        PetModel petModel = petMapper.toModel(petDTO);
        PetModel savedPet = petRepository.save(petModel);
        return petMapper.toDTO(savedPet);
    }
}
