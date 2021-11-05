package com.Safetynet.Repository;

import com.Safetynet.Data.GeneralData;
import com.Safetynet.Data.MedicalRecordsDAOTestData;
import com.Safetynet.Data.PersonDAOTestData;
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
    public void addFirestationTest(){
        //Given
        MedicalRecords medicalRecordsToAdd = MedicalRecordsDAOTestData.medicalRecordsToAdd();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithAddedMedicalRecord();
        //When
        medicalRecordsDAO.addMedicalRecords(medicalRecordsToAdd);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }

    @Test
    public void editFirestationTest(){
        //Given
        MedicalRecords medicalRecordsToEdit = MedicalRecordsDAOTestData.medicalRecordsToEdit();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithEditedMedicalRecord();
        //When
        medicalRecordsDAO.editMedicalRecords(medicalRecordsToEdit);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }

    @Test
    public void deleteFirestationTest(){
        //Given
        MedicalRecords medicalRecordsToDelete = MedicalRecordsDAOTestData.medicalRecordsToDelete();
        List<MedicalRecords> expected = MedicalRecordsDAOTestData.getMedicalRecordsListWithDeletedMedicalRecord();
        //When
        medicalRecordsDAO.deleteMedicalRecords(medicalRecordsToDelete);
        //Then
        assertEquals(expected,medicalRecordsDAO.getMedicalRecordsList());
    }
}
