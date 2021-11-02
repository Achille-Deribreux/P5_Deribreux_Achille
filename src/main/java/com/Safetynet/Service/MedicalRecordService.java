package com.Safetynet.Service;

import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.MedicalRecordsDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MedicalRecordService implements IMedicalRecordService{

    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    @Override
    public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords) {
        return medicalRecordsDAO.addMedicalRecords(medicalRecords);
    }

    @Override
    public MedicalRecords editMedicalRecords(MedicalRecords medicalRecords) {
        return medicalRecordsDAO.editMedicalRecords(medicalRecords);
    }

    @Override
    public void deleteMedicalRecords(MedicalRecords medicalRecords) {
        medicalRecordsDAO.deleteMedicalRecords(medicalRecords);
    }
}
