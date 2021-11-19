package com.Safetynet.Controller;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Service.MedicalRecordService;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MedicalRecordsController {

    @Autowired
    MedicalRecordService medicalRecordService;

    public void setMedicalRecordService(MedicalRecordService medicalRecordService) {
        this.medicalRecordService = medicalRecordService;
    }

    private static final Logger LOGGER = LogManager.getLogger(MedicalRecordsController.class);

    @GetMapping(value="/medicalRecords")
    public ResponseEntity<List<MedicalRecords>> getAllMedicalRecords(){
        LOGGER.info("Requête reçue à /medicalRecords");
        return new ResponseEntity<>(medicalRecordService.findAll(),HttpStatus.OK);
    }

    @GetMapping(value ="/medicalRecord")
    public ResponseEntity<MedicalRecords> getMedicalRecordByName(@RequestParam String firstName,@RequestParam String lastName){
        LOGGER.info("Requête reçue à /medicalRecords");
        return new ResponseEntity<>(medicalRecordService.findByName(firstName, lastName), HttpStatus.OK);
    }

    @PostMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        LOGGER.info("Requête Post reçue à /medicalRecord");
        if(medicalRecords == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            medicalRecordService.addMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content added successfully", HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> editMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        LOGGER.info("Requête Put reçue à /medicalRecord");
        if(medicalRecords == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            medicalRecordService.editMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content updated successfully", HttpStatus.OK);
        }

    }
    @DeleteMapping(value = "/medicalRecord", consumes = "application/json")
    public ResponseEntity<String> deleteMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        LOGGER.info("Requête Delete reçue à /medicalRecord");
        if(medicalRecords == null) {
            LOGGER.error("pas de body fourni");
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }
        else {
            medicalRecordService.deleteMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content deleted successfully", HttpStatus.OK);
        }
    }
}
