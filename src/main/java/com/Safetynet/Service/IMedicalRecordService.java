package com.Safetynet.Service;

import com.Safetynet.Model.MedicalRecords;

public interface IMedicalRecordService {
    public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords);
    public MedicalRecords editMedicalRecords(MedicalRecords medicalRecords);
    public void deleteMedicalRecords(MedicalRecords medicalRecords);
}
