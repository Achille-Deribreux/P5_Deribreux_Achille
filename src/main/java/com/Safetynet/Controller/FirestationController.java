package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class FirestationController {

    @Autowired
    FirestationService firestationService;

    @PostMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addFirestation(@RequestBody Firestations firestations){
        if(firestations == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            firestationService.addFirestation(firestations);
            return new ResponseEntity<>("Content added successfully", HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> editFirestation(@RequestBody Firestations firestations){
        if(firestations == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            firestationService.editFirestation(firestations);
            return new ResponseEntity<>("Content update successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/firestation", consumes = "application/json")
    public ResponseEntity<String> deleteFirestation(@RequestBody Firestations firestations){
        if(firestations == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            firestationService.deleteFirestation(firestations);
            return new ResponseEntity<>("Content deleted successfully", HttpStatus.OK);
        }
    }


}
