package com.Safetynet.Repository;

import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsAlreadyExistsException;
import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsNotFoundException;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Model.Person;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MedicalRecordsDAO implements IMedicalRecordDAO{
    private List<MedicalRecords> medicalRecordsList;
    private static final Logger LOGGER = LogManager.getLogger(MedicalRecordsDAO.class);

    public List<MedicalRecords> getMedicalRecordsList() {
        return medicalRecordsList;
    }

    public void setMedicalRecordsList(List<MedicalRecords> medicalRecordsList) {
        this.medicalRecordsList = medicalRecordsList;
    }

    public MedicalRecords findByName(String firstName, String lastName){
        return  medicalRecordsList.stream()
                .filter(person -> person.getFirstName().equals(firstName) && person.getLastName().equals(lastName))
                .findAny().orElseThrow(()-> new MedicalRecordsNotFoundException(firstName,lastName));
    }




    @Override
    public MedicalRecords addMedicalRecords(MedicalRecords medicalRecords) {
        if (medicalRecordsList.stream().anyMatch(m->m.getFirstName().equals(medicalRecords.getFirstName())&&m.getLastName().equals(medicalRecords.getLastName()))) {
            throw new MedicalRecordsAlreadyExistsException(medicalRecords.getFirstName(),medicalRecords.getLastName());
        }else {
            medicalRecordsList.add(medicalRecords);
            LOGGER.info("ressource bien ajoutée");
            return medicalRecords;
        }
    }

    @Override
    public MedicalRecords editMedicalRecords(MedicalRecords medicalRecords) {
        MedicalRecords medicalRecordsToUpdate = medicalRecordsList.stream()
                .filter(m -> m.getFirstName().equals(medicalRecords.getFirstName()) && m.getLastName().equals(medicalRecords.getLastName()))
                .findAny().orElseThrow(()-> new MedicalRecordsNotFoundException(medicalRecords.getFirstName(),medicalRecords.getLastName()));
        medicalRecordsList.set(medicalRecordsList.indexOf(medicalRecordsToUpdate),medicalRecords);
        LOGGER.info("MedicalRecord bien modifié");
        return medicalRecords;
    }

    @Override
    public void deleteMedicalRecords(MedicalRecords medicalRecords) {
        MedicalRecords medicalRecordsToDelete = medicalRecordsList.stream()
                .filter(m -> m.getFirstName().equals(medicalRecords.getFirstName()) && m.getLastName().equals(medicalRecords.getLastName()))
                .findAny().orElseThrow(()->new MedicalRecordsNotFoundException(medicalRecords.getFirstName(),medicalRecords.getLastName()));
            medicalRecordsList.remove(medicalRecordsToDelete);
            LOGGER.info("MedicalRecord bien supprimé");
    }
}
