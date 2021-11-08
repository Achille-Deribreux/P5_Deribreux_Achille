package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Service.FirestationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {

    @Autowired
    FirestationService firestationService;

    @GetMapping(value="/firestation", consumes = "application/json")
    public ResponseEntity<List<Firestations>> getAllFirestations(){
        return new ResponseEntity<>(firestationService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/firestation/{stationNumber}", consumes = "application/json")
    public ResponseEntity<Firestations> getAllFirestations(@PathVariable Integer stationNumber){
        if(firestationService.findByNumber(stationNumber) != null) {
            return new ResponseEntity<>(firestationService.findByNumber(stationNumber), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
    }

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
