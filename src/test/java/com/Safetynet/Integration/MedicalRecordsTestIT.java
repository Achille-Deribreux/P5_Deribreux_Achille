package com.Safetynet.Integration;

import com.Safetynet.Controller.MedicalRecordsController;
import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.MedicalRecordsTestITData;
import com.Safetynet.Model.MedicalRecords;
import com.Safetynet.Repository.MedicalRecordsDAO;
import com.Safetynet.Service.MedicalRecordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class MedicalRecordsTestIT {
    MedicalRecordsController medicalRecordsController = new MedicalRecordsController();
    MedicalRecordService medicalRecordService = new MedicalRecordService();
    MedicalRecordsDAO medicalRecordsDAO = new MedicalRecordsDAO();

    @BeforeEach
    public void setup(){
        medicalRecordsDAO.setMedicalRecordsList(GeneralData.getMedicalRecordsList());
        medicalRecordService.setMedicalRecordsDAO(medicalRecordsDAO);
        medicalRecordsController.setMedicalRecordService(medicalRecordService);
    }

    @Test
    public void getAllMedicalRecordsIT(){
        //Given
        List<MedicalRecords> expected = GeneralData.getMedicalRecordsList();
        List<MedicalRecords> result;
        //When
        result = medicalRecordsController.getAllMedicalRecords().getBody();
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void getMedicalRecordByNameIT(){
        //Given
        String firstName = "John";
        String lastName = "Boyd";
        MedicalRecords expected = MedicalRecordsTestITData.findMedicalRecordsByName();
        MedicalRecords result;
        //When
        result = medicalRecordsController.getMedicalRecordByName(firstName,lastName).getBody();
        //Then
        assertEquals(expected, result);
    }

    @Test
    public void addMedicalRecordTestIT(){
        //Given
        MedicalRecords medicalRecordsToAdd = MedicalRecordsTestITData.getMedicalRecordToAdd();
        List<MedicalRecords> expected = MedicalRecordsTestITData.getMedicalRecordsListWithAddedMedicalRecords();
        //When
        medicalRecordsController.addMedicalRecord(medicalRecordsToAdd);
        //Then
        List<MedicalRecords> result = medicalRecordsDAO.getMedicalRecordsList();
        assertEquals(expected, result);
    }

    @Test
    public void editMedicalRecordTestIT(){
        //Given
        MedicalRecords medicalRecordsToEdit = MedicalRecordsTestITData.getMedicalRecordToEdit();
        List<MedicalRecords> expected = MedicalRecordsTestITData.getMedicalRecordsListWithEditedMedicalRecords();
        //When
        medicalRecordsController.editMedicalRecord(medicalRecordsToEdit);
        //Then
        List<MedicalRecords> result = medicalRecordsDAO.getMedicalRecordsList();
        assertEquals(expected, result);
    }

    @Test
    public void deleteMedicalRecordIT(){
        //Given
        MedicalRecords medicalRecordsToDelete = MedicalRecordsTestITData.getMedicalRecordsToDelete();
        List<MedicalRecords> expected = MedicalRecordsTestITData.getMedicalRecordsListWithDeletedMedicalRecords();
        //When
        medicalRecordsController.deleteMedicalRecord(medicalRecordsToDelete);
        //Then
        List<MedicalRecords> result = medicalRecordsDAO.getMedicalRecordsList();
        assertEquals(expected, result);
    }


}
