package java.fundamentals.vetclinic.visit.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.fundamentals.vetclinic.visit.DTO.VisitDTO;
import java.fundamentals.vetclinic.visit.DTO.VisitWithPetDTO;
import java.fundamentals.vetclinic.visit.action.CrudVisitAction;
import java.fundamentals.vetclinic.visit.action.LoadVisitAction;


@RestController
@RequestMapping("/visit")
public class VisitController {

    @Autowired
    LoadVisitAction loadVisitAction;

    @Autowired
    CrudVisitAction crudVisitAction;

    @GetMapping("/getVisitById")
    public VisitWithPetDTO getVisitById(@RequestParam long id){
        return loadVisitAction.getVisitById(id);
    }

    @PostMapping("/createVisit")
    public VisitDTO createNewVisit(@RequestBody VisitDTO visit){
        return crudVisitAction.createVisit(visit);
    }
}
