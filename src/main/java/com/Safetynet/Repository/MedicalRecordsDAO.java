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
        try{
            if (medicalRecords == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                MedicalRecords medicalRecordsToUpdate = medicalRecordsList.stream()
                        .filter(m -> m.getFirstName().equals(medicalRecords.getFirstName()) && m.getLastName().equals(medicalRecords.getLastName()))
                        .findAny().orElse(null);
                if(medicalRecordsToUpdate == null){
                    LOGGER.error("MedicalRecord non trouvé");
                    throw new NullPointerException();
                }else {
                    medicalRecordsList.set(medicalRecordsList.indexOf(medicalRecordsToUpdate),medicalRecords);
                    LOGGER.info("MedicalRecord bien modifié");
                    return medicalRecords;
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de modifier un medicalRecord", e);
        }
        return null;//TODO : change return statement
    }

    @Override
    public void deleteMedicalRecords(MedicalRecords medicalRecords) {
        try{
            if (medicalRecords == null) {
                LOGGER.error("argument null");
                throw new NullPointerException();
            }else {
                MedicalRecords medicalRecordsToDelete = medicalRecordsList.stream()
                        .filter(m -> m.getFirstName().equals(medicalRecords.getFirstName()) && m.getLastName().equals(medicalRecords.getLastName()))
                        .findAny().orElse(null);
                if(medicalRecordsToDelete == null){
                    LOGGER.error("ressource non trouvée");
                    throw new NullPointerException();
                }else {
                    medicalRecordsList.remove(medicalRecordsToDelete);
                    LOGGER.info("MedicalRecord bien supprimé");
                }
            }
        }catch(Exception e){
            LOGGER.error("impossible de supprimer un medicalRecord", e);
        }
    }
}
