package java.fundamentals.vetclinic.pet.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.fundamentals.vetclinic.pet.DTO.PetDTO;
import java.fundamentals.vetclinic.pet.DTO.PetwithOwnerDTO;
import java.fundamentals.vetclinic.pet.action.CrudPetAction;
import java.fundamentals.vetclinic.pet.action.LoadPetAction;


@RestController
@RequestMapping("/pet")
public class PetController {

    @Autowired
    LoadPetAction loadPetAction;

    @Autowired
    CrudPetAction crudPetAction;

    @GetMapping("/getPetById")
    public PetwithOwnerDTO getPetById(@RequestParam long id){
        return loadPetAction.getPetById(id);
    }

    @PostMapping("/createPet")
    public PetDTO createNewPet(@RequestBody PetDTO pet){
        return crudPetAction.createPet(pet);
    }
}
