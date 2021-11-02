package com.Safetynet.Repository;

import com.Safetynet.Model.MedicalRecords;

import java.util.List;

public class MedicalRecordsDAO implements IMedicalRecordDAO{
    private List<MedicalRecords> medicalRecordsList;

    public List<MedicalRecords> getMedicalRecordsList() {
        return medicalRecordsList;
    }

    public void setMedicalRecordsList(List<MedicalRecords> medicalRecordsList) {
        this.medicalRecordsList = medicalRecordsList;
    }

    @Override
    public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords) {
        medicalRecordsList.add(medicalRecords);
        return medicalRecords;
    }

    @Override
    public MedicalRecords editMedicalRecords(MedicalRecords medicalRecords) {
        MedicalRecords medicalRecordsToUpdate = null;
        for(MedicalRecords m : medicalRecordsList){
            if(m.getFirstName().equals(medicalRecords.getFirstName())&& m.getLastName().equals(medicalRecords.getLastName())){
                medicalRecordsToUpdate = m;
            }
        }
        if(medicalRecordsToUpdate != null){
            medicalRecordsList.set(medicalRecordsList.indexOf(medicalRecordsToUpdate),medicalRecords);
            return medicalRecords;
        }
        return null;
    }

    @Override
    public void deleteMedicalRecords(MedicalRecords medicalRecords) {
        MedicalRecords medicalRecordsToDelete = null;
        for(MedicalRecords m : medicalRecordsList){
            if(m.getFirstName().equals(medicalRecords.getFirstName())&& m.getLastName().equals(medicalRecords.getLastName())){
                medicalRecordsToDelete = m;
            }
        }
        if(medicalRecordsToDelete != null){
            medicalRecordsList.remove(medicalRecordsToDelete);
        }
    }
}
