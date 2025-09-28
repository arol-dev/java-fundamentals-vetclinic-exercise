package java.fundamentals.vetclinic.pet.action;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.fundamentals.vetclinic.owner.model.OwnerModel;
import java.fundamentals.vetclinic.owner.repository.OwnerRepository;
import java.fundamentals.vetclinic.pet.DTO.PetDTO;
import java.fundamentals.vetclinic.pet.DTO.PetwithOwnerDTO;
import java.fundamentals.vetclinic.pet.mapper.PetMapper;
import java.fundamentals.vetclinic.pet.mapper.PetWithOwnerMapper;
import java.fundamentals.vetclinic.pet.model.PetModel;
import java.fundamentals.vetclinic.pet.repository.PetRepository;


@Service
public class LoadPetAction {

    @Autowired
    private PetRepository petRepository;

    @Autowired
    private OwnerRepository ownerRepository;

    @Autowired
    private PetMapper petMapper;

    @Autowired
    private PetWithOwnerMapper petWithOwnerMapper;

    public PetwithOwnerDTO getPetById(long id) {

        PetModel petModel = petRepository.findById(id);
        OwnerModel ownerModel = ownerRepository.findById((petModel.getOwnerId()));


        return petWithOwnerMapper.petWithOwnerDTO(petModel,ownerModel);
    }
}
