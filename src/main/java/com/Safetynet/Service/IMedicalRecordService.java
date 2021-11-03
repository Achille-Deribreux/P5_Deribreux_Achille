package com.Safetynet.Service;

import com.Safetynet.Model.MedicalRecords;

import java.util.List;

public interface IMedicalRecordService {
    List<MedicalRecords> findAll();
    List<String>findAllergiesByName(String firstName, String lastName);
    List<String>findMedicationsByName(String firstName, String lastName);
    MedicalRecords addMedicalRecords(MedicalRecords medicalRecords);
    MedicalRecords editMedicalRecords(MedicalRecords medicalRecords);
    void deleteMedicalRecords(MedicalRecords medicalRecords);
}
