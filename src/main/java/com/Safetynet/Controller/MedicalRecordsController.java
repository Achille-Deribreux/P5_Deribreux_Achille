package com.Safetynet.Controller;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class MedicalRecordsController {

    @Autowired
    MedicalRecordService medicalRecordService;

    @PostMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> addMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        if(medicalRecords == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            medicalRecordService.addMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content added successfully", HttpStatus.CREATED);
        }
    }

    @PutMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public ResponseEntity<String> editMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        if(medicalRecords == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            medicalRecordService.editMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content updated successfully", HttpStatus.OK);
        }

    }
    @DeleteMapping(value = "/medicalRecord", consumes = "application/json")
    public ResponseEntity<String> deleteMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        if(medicalRecords == null) {
            return new ResponseEntity<>("Content is empty", HttpStatus.NO_CONTENT);
        }else {
            medicalRecordService.deleteMedicalRecords(medicalRecords);
            return new ResponseEntity<>("Content deleted successfully", HttpStatus.OK);
        }
    }
}
