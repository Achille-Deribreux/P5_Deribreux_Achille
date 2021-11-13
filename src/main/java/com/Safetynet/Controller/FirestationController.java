package com.Safetynet.Controller;

import com.Safetynet.Model.Firestations;
import com.Safetynet.Service.FirestationService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FirestationController {

    @Autowired
    FirestationService firestationService;

    private static final Logger LOGGER = LogManager.getLogger(FirestationController.class);


    @GetMapping(value="/firestations")
    public ResponseEntity<List<Firestations>> getAllFirestations(){
        LOGGER.info("Requête reçue à /firestations");
        return new ResponseEntity<>(firestationService.findAll(), HttpStatus.OK);
    }

    @GetMapping(value="/firestations/{stationNumber}")
    public ResponseEntity<Firestations> getFirestationsByNumber(@PathVariable Integer stationNumber){
        LOGGER.info("Requête reçue à /firestations/{stationNumber}");
        if(stationNumber == null){
            LOGGER.error("pas de stationNumber fourni");
            return new ResponseEntity<>(null, HttpStatus.NO_CONTENT);
        }
        else {
            return new ResponseEntity<>(firestationService.findByNumber(stationNumber), HttpStatus.OK);
        }
    }

    @PostMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addFirestation(@RequestBody Firestations firestations){
        LOGGER.info("Requête Post reçue à /firestation");
        if(firestations == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            firestationService.addFirestation(firestations);
            return new ResponseEntity<>("Content added successfully", HttpStatus.CREATED);
        }
    }

    @PutMapping(value="/firestation", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> editFirestation(@RequestBody Firestations firestations){
        LOGGER.info("Requête Put reçue à /firestation");
        if(firestations == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            firestationService.editFirestation(firestations);
            return new ResponseEntity<>("Content update successfully", HttpStatus.OK);
        }
    }

    @DeleteMapping(value="/firestation", consumes = "application/json")
    public ResponseEntity<String> deleteFirestation(@RequestBody Firestations firestations){
        LOGGER.info("Requête Delete reçue à /firestation");
        if(firestations == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            firestationService.deleteFirestation(firestations);
            return new ResponseEntity<>("Content deleted successfully", HttpStatus.OK);
        }
    }


}
