package com.Safetynet.Repository;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.MedicalRecordsDAOTestData;
import com.Safetynet.Data.PersonDAOTestData;
import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsAlreadyExistsException;
import com.Safetynet.Exceptions.CustomExceptions.MedicalRecordsNotFoundException;
import com.Safetynet.Exceptions.CustomExceptions.PersonAlreadyExistsException;
import com.Safetynet.Exceptions.CustomExceptions.PersonNotFoundException;
import com.Safetynet.Model.Data;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Model.Person;
import com.Safetynet.Utils.Dataloader;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class MedicalRecordsDAOTest {

    @Autowired
    Dataloader dataloader;

    @Autowired
    MedicalRecordsDAO medicalRecordsDAO;

    @BeforeEach
    public void setup(){
        Data dataTest = new Data(GeneralData.getPersonList(),GeneralData.getFirestationsList(), GeneralData.getMedicalRecordsList());
        ((Dataloader) dataloader).setDataFile(dataTest);
    }

    @Test
    public void findByNameTest(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecords expected = new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        MedicalRecords result;
        //When
        result = medicalRecordsDAO.findByName(firstName,lastName);
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void medicalRecordNotFoundFindByNameTest(){
        //Given
        String firstName = "a";
        String lastName = "b";
        //When & Then
        assertThrows(MedicalRecordsNotFoundException.class, () -> medicalRecordsDAO.findByName(firstName,lastName));
    }

    @Test
    public void addMedicalRecordTest(){
        //Given
        MedicalRecords medicalRecordsToAdd = MedicalRecordsDAOTestData.medicalRecordsToAdd();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithAddedMedicalRecord();
        //When
        medicalRecordsDAO.addMedicalRecords(medicalRecordsToAdd);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }

    @Test
    public void addAlreadyInMedicalRecordTest(){
        //Given
       MedicalRecords alreadyInMedicalRecord =  new MedicalRecords("John", "Boyd", "03/06/1984", List.of("aznol:350mg", "hydrapermazol:100mg"), List.of("nillacilan"));
        //When & Then
        assertThrows(MedicalRecordsAlreadyExistsException.class, () -> medicalRecordsDAO.addMedicalRecords(alreadyInMedicalRecord));
    }

    @Test
    public void editMedicalRecordTest(){
        //Given
        MedicalRecords medicalRecordsToEdit = MedicalRecordsDAOTestData.medicalRecordsToEdit();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithEditedMedicalRecord();
        //When
        medicalRecordsDAO.editMedicalRecords(medicalRecordsToEdit);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }

    @Test
    public void medicalRecordNotFoundEditTest(){
        //Given
        MedicalRecords medicalRecordNotInList = MedicalRecordsDAOTestData.medicalRecordsToAdd();
        //When & Then
        assertThrows(MedicalRecordsNotFoundException.class, () -> medicalRecordsDAO.editMedicalRecords(medicalRecordNotInList));
    }

    @Test
    public void deleteMedicalRecordTest(){
        //Given
        MedicalRecords medicalRecordsToDelete = MedicalRecordsDAOTestData.medicalRecordsToDelete();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithDeletedMedicalRecord();
        //When
        medicalRecordsDAO.deleteMedicalRecords(medicalRecordsToDelete);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }

    @Test
    public void medicalRecordNotFoundDeleteTest(){
        //Given
        MedicalRecords medicalRecordNotInList = MedicalRecordsDAOTestData.medicalRecordsToAdd();
        //When & Then
        assertThrows(MedicalRecordsNotFoundException.class, () -> medicalRecordsDAO.deleteMedicalRecords(medicalRecordNotInList));
    }
}
