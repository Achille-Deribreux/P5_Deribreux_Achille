package com.Safetynet.Controller;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Service.MedicalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
public class MedicalRecordsController {

    @Autowired
    MedicalRecordService medicalRecordService;

    //TODO: Get some responses & codes

    @PostMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public void addMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        medicalRecordService.addMedicalRecords(medicalRecords);
    }
    @PutMapping(value = "/medicalRecord", consumes = "application/json", produces = "application/json")
    public void editMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        medicalRecordService.editMedicalRecords(medicalRecords);
    }
    @DeleteMapping(value = "/medicalRecord", consumes = "application/json")
    public void deleteMedicalRecord(@RequestBody MedicalRecords medicalRecords){
        medicalRecordService.deleteMedicalRecords(medicalRecords);
    }
}
