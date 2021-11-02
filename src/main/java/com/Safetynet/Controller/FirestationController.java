package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class FirestationController {

    @Autowired
    FirestationService firestationService;

    //TODO: Get some responses & codes

    @PostMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public void addFirestation(@RequestBody Firestations firestations){
        firestationService.addFirestation(firestations);
    }

    @PutMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public void editFirestation(@RequestBody Firestations firestations){
        firestationService.editFirestation(firestations);
    }

    @DeleteMapping(value="/firestation", consumes = "application/json")
    public void deleteFirestation(@RequestBody Firestations firestations){
        firestationService.deleteFirestation(firestations);
    }


}
