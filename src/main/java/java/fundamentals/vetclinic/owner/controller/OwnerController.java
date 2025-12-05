package java.fundamentals.vetclinic.owner.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.fundamentals.vetclinic.owner.DTO.OwnerDTO;
import java.fundamentals.vetclinic.owner.action.CrudOwnerAction;
import java.fundamentals.vetclinic.owner.action.LoadOwnerAction;

@RestController
@RequestMapping("/owners")
public class OwnerController {

    @Autowired
    LoadOwnerAction loadOwnerAction;

    @Autowired
    CrudOwnerAction crudOwnerAction;

    @GetMapping("/getOwnerById")
    public OwnerDTO getOwnerById(@RequestParam long id){
        return loadOwnerAction.getOwnerById(id);
    }

    @PostMapping("/createOwner")
    public OwnerDTO createNewOwner(@RequestBody OwnerDTO owner){
        return crudOwnerAction.createOwner(owner);
    }
}
