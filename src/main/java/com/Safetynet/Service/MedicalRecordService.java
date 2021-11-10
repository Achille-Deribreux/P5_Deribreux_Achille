package com.Safetynet.Service;

import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsNotFoundException;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.MedicalRecordsDAO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService{

    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    public MedicalRecords findByName(String firstName, String lastName){
        return medicalRecordsDAO.findByName(firstName,lastName);
    }

    public Integer findAgeFromName (String firstName, String lastName){
        MedicalRecords medicalRecordsObject = findAll().stream()
                .filter(medicalRecords -> medicalRecords.getFirstName().equals(firstName)&&medicalRecords.getLastName().equals(lastName))
                .findAny().orElseThrow(()-> new MedicalRecordsNotFoundException(firstName, lastName));
        return findAgeFromBirthdate(medicalRecordsObject.getBirthdate());

    }

    public Integer findAgeFromBirthdate(String birthdate){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Period period = LocalDate.parse(birthdate, formatter).until(LocalDate.now());
        return period.getYears();
    }

    @Override
    public List<String>findAllergiesByName(String firstName, String lastName){
        for (MedicalRecords medicalRecords : findAll()){
            if(medicalRecords.getFirstName().equals(firstName) && medicalRecords.getLastName().equals(lastName)){
                return medicalRecords.getAllergies();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<String>findMedicationsByName(String firstName, String lastName){
        for (MedicalRecords medicalRecords : findAll()){
            if(medicalRecords.getFirstName().equals(firstName) && medicalRecords.getLastName().equals(lastName)){
                return medicalRecords.getMedications();
            }
        }
        return Collections.emptyList();
    }

    @Override
    public List<MedicalRecords> findAll(){
        return medicalRecordsDAO.getMedicalRecordsList();
    }

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
