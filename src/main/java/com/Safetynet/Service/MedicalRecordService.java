package com.Safetynet.Service;

import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsNotFoundException;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.MedicalRecordsDAO;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MedicalRecordService implements IMedicalRecordService{

    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    private static final Logger LOGGER = LogManager.getLogger(MedicalRecordService.class);

    public void setMedicalRecordsDAO(MedicalRecordsDAO medicalRecordsDAO) {
        LOGGER.debug("medicalRecordsDAO setted");
        this.medicalRecordsDAO = medicalRecordsDAO;
    }

    public MedicalRecords findByName(String firstName, String lastName){
        LOGGER.debug("medicalRecordsDAO.findByName have been called with "+firstName+" "+lastName);
        return medicalRecordsDAO.findByName(firstName,lastName);
    }

    public Integer findAgeFromName (String firstName, String lastName){
        MedicalRecords medicalRecordsObject = findAll().stream()
                .filter(medicalRecords -> medicalRecords.getFirstName().equals(firstName)&&medicalRecords.getLastName().equals(lastName))
                .findAny().orElseThrow(()-> new MedicalRecordsNotFoundException(firstName, lastName));
        LOGGER.debug("Find Medical for people :"+firstName+" "+lastName+" : "+medicalRecordsObject);
        return findAgeFromBirthdate(medicalRecordsObject.getBirthdate());

    }

    public Integer findAgeFromBirthdate(String birthdate){
        LOGGER.debug("Birthdate before format : "+birthdate);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
        Period period = LocalDate.parse(birthdate, formatter).until(LocalDate.now());
        LOGGER.debug("Calculate time between Today: "+LocalDate.now()+" and birthdate "+ LocalDate.parse(birthdate, formatter));
        LOGGER.debug("Birthdate after format : "+ period.getYears());
        return period.getYears();
    }

    @Override
    public List<String>findAllergiesByName(String firstName, String lastName){
        LOGGER.debug("search allergies for : "+firstName+" "+lastName);
        for (MedicalRecords medicalRecords : findAll()){
            if(medicalRecords.getFirstName().equals(firstName) && medicalRecords.getLastName().equals(lastName)){
                LOGGER.debug("MedicalRecords & Allergies find for : "+firstName+" "+lastName+ " : "+medicalRecords.getAllergies());
                return medicalRecords.getAllergies();
            }
        }
        LOGGER.debug("no allergies for : "+firstName+" "+lastName);
        return Collections.emptyList();
    }

    @Override
    public List<String>findMedicationsByName(String firstName, String lastName){
        LOGGER.debug("search medication for : "+firstName+" "+lastName);
        for (MedicalRecords medicalRecords : findAll()){
            if(medicalRecords.getFirstName().equals(firstName) && medicalRecords.getLastName().equals(lastName)){
                LOGGER.debug("MedicalRecords & medication find for : "+firstName+" "+lastName+ " : "+medicalRecords.getMedications());
                return medicalRecords.getMedications();
            }
        }
        LOGGER.debug("no medication for : "+firstName+" "+lastName);
        return Collections.emptyList();
    }

    @Override
    public List<MedicalRecords> findAll(){
        LOGGER.debug("medicalRecordsDAO.getMedicalRecordsList have been called");
        return medicalRecordsDAO.getMedicalRecordsList();
    }

    @Override
    public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords) {
        LOGGER.debug("medicalRecordsDAO.addMedicalRecords have been called with "+medicalRecords);
        return medicalRecordsDAO.addMedicalRecords(medicalRecords);
    }

    @Override
    public MedicalRecords editMedicalRecords(MedicalRecords medicalRecords) {
        LOGGER.debug("medicalRecordsDAO.editMedicalRecords have been called with "+medicalRecords);
        return medicalRecordsDAO.editMedicalRecords(medicalRecords);
    }

    @Override
    public void deleteMedicalRecords(MedicalRecords medicalRecords) {
        LOGGER.debug("medicalRecordsDAO.deleteMedicalRecords have been called with "+medicalRecords);
        medicalRecordsDAO.deleteMedicalRecords(medicalRecords);
    }
}
